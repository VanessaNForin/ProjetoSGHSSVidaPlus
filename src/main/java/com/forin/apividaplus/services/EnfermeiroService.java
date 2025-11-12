package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.EnfermeiroInputDTO;
import com.forin.apividaplus.dtos.EnfermeiroResponseDTO;
import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.mappers.EnfermeiroMapper;
import com.forin.apividaplus.mappers.InternacaoMapper;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.repositories.EnfermeiroRepository;
import com.forin.apividaplus.repositories.HospitalRepository;
import com.forin.apividaplus.repositories.InternacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.forin.apividaplus.mappers.EnfermeiroMapper.toDTO;
import static com.forin.apividaplus.mappers.EnfermeiroMapper.toModel;
import static com.forin.apividaplus.services.Utils.*;

@Service
public class EnfermeiroService {

    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private InternacaoRepository internacaoRepository;

    @Transactional
    public Enfermeiro cadastrarEnfermeiro(EnfermeiroInputDTO enfermeiro){
        Enfermeiro novoEnfermeiro = toModel(enfermeiro);

        novoEnfermeiro.setIdEnfermeiro(criarId(Enfermeiro.class, enfermeiroRepository.count()));
        novoEnfermeiro.setCadastroAtivo(true);
        novoEnfermeiro.setDataNascimento(formatarData(enfermeiro.getDataNascimento()));
        novoEnfermeiro.setHospitalTrabalho(
                hospitalRepository.findById(enfermeiro.getIdHospitalTrabalho())
                        .orElseThrow(() -> new RuntimeException("Hospital não encontrado"))
        );

        return enfermeiroRepository.save(novoEnfermeiro);
    }

    public EnfermeiroResponseDTO consultarEnfermeiro(String idEnfermeiro){
        Enfermeiro enfermeiro = enfermeiroRepository.findById(idEnfermeiro).orElseThrow(
                ()-> new RuntimeException("Enfermeiro não encontrado")
        );

        return toDTO(enfermeiro);
    }

    public void deletarEnfermeiro(String idEnfermeiro){
        enfermeiroRepository.deleteById(idEnfermeiro);
    }

    public List<InternacaoResponseDTO> consultarInternacoesResponsaveis(String idEnfermeiro){
        Enfermeiro enfermeiro = enfermeiroRepository.findById(idEnfermeiro).orElseThrow(
                ()-> new RuntimeException("Enfermeiro não encontrado")
        );

        return enfermeiro.getInterncaosResponsavel()
                .stream()
                .map(internacao -> InternacaoMapper.toDTO(internacao))
                .collect(Collectors.toList());
    }

    public void atualizarProntuario(String idEnfermeiro, String idInternacao, String novoProntuario){
        Enfermeiro enfermeiro = enfermeiroRepository.findById(idEnfermeiro).orElseThrow(
                ()-> new RuntimeException("Enfermeiro não encontrado")
        );

        Internacao internacao = internacaoRepository.findById(idInternacao).orElseThrow(
                () -> new RuntimeException("Internação não encontrada")
        );

        if (!internacao.getEnfermeiroResponsavel().getIdEnfermeiro().equals(enfermeiro.getIdEnfermeiro())){
            throw new RuntimeException("Você não tem permissão para atualizar este prontuário.");
        }

        String protuarioAtual = internacao.getProntuario();

        if(protuarioAtual == null || protuarioAtual.isBlank()){
            internacao.setProntuario(
                    "\n\n --ATUALIZADO EM :" + formatarDataString(LocalDate.now()) + "--\n" + novoProntuario
            );
        } else {
            internacao.setProntuario(
                    protuarioAtual + "\n\n --ATUALIZADO EM :" + formatarDataString(LocalDate.now()) + "--\n" + novoProntuario
            );
        }

        internacaoRepository.save(internacao);
    }

}
