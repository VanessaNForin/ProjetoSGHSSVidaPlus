package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.dtos.MedicoInputDTO;
import com.forin.apividaplus.dtos.MedicoResponseDTO;
import com.forin.apividaplus.mappers.InternacaoMapper;
import com.forin.apividaplus.mappers.MedicoMapper;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.repositories.InternacaoRepository;
import com.forin.apividaplus.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.forin.apividaplus.mappers.MedicoMapper.toDTO;
import static com.forin.apividaplus.mappers.MedicoMapper.toModel;
import static com.forin.apividaplus.services.Utils.*;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private InternacaoRepository internacaoRepository;

    @Transactional
    public Medico cadastrarMedico(MedicoInputDTO medico){
        Medico novoMedico = toModel(medico);

        novoMedico.setIdMedico(criarId(Medico.class, medicoRepository.count()));
        novoMedico.setCadastroAtivo(true);
        novoMedico.setDataNascimento(formatarData(medico.getDataNascimento()));

        return medicoRepository.save(novoMedico);
    }

    public MedicoResponseDTO consultarMedico(String idMedico){
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(
                ()-> new RuntimeException("Médico não encontrado")
        );

        return toDTO(medico);
    }

    public void deletarMedico(String idMedico){
        medicoRepository.deleteById(idMedico);
    }

    public List<InternacaoResponseDTO> consultarInternacoesResponsaveis(String idMedico){
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(
                ()-> new RuntimeException("Médico não encontrado")
        );

        return medico.getInternacoesRealizadas()
                .stream()
                .map(internacao -> InternacaoMapper.toDTO(internacao))
                .collect(Collectors.toList());

    }

    public void atualizarProntuario(String idMedico, String idInternacao, String novoProntuario){
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(
                ()-> new RuntimeException("Medico não encontrado")
        );

        Internacao internacao = internacaoRepository.findById(idInternacao).orElseThrow(
                ()-> new RuntimeException("Internacao não encontrada")
        );

        if (!internacao.getMedicoResponsavel().getIdMedico().equals(medico.getIdMedico())){
            throw new RuntimeException("Você não tem permissão para atualizar este prontuário.");
        }

        String prontuarioAtual = internacao.getProntuario();

        if(prontuarioAtual == null|| prontuarioAtual.isBlank()){
            internacao.setProntuario("\n\n --ATUALIZADO EM :" + formatarDataString(LocalDate.now()) + "--\n" + novoProntuario);
        } else {
            internacao.setProntuario
                    (prontuarioAtual + "\n\n --ATUALIZADO EM :" + formatarDataString(LocalDate.now()) + "--\n" + novoProntuario);
        }

        internacaoRepository.save(internacao);
    }

}
