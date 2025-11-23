package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.ExameResponseDTO;
import com.forin.apividaplus.dtos.TecnicoInputDTO;
import com.forin.apividaplus.dtos.TecnicoResponseDTO;
import com.forin.apividaplus.mappers.ExameMapper;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.models.enums.EspecialidadeTecnica;
import com.forin.apividaplus.models.pessoas.Tecnico;
import com.forin.apividaplus.repositories.ExameRepository;
import com.forin.apividaplus.repositories.TecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.forin.apividaplus.mappers.TecnicoMapper.toDTO;
import static com.forin.apividaplus.mappers.TecnicoMapper.toModel;
import static com.forin.apividaplus.services.Utils.*;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Transactional
    public TecnicoResponseDTO cadastrarTecnico(TecnicoInputDTO tecnico){
        Tecnico novoTecnico = toModel(tecnico);

        novoTecnico.setIdTecnico(criarId(Tecnico.class, tecnicoRepository.count()));
        novoTecnico.setCadastroAtivo(true);
        novoTecnico.setDataNascimento(validarDataNascimento(tecnico.getDataNascimento()));
        novoTecnico.setRegistroProfissional(formatarRegistroProfissional(tecnico.getEspecialidadeTecnica(),tecnico.getNumeroRegistroProfissional()));

        tecnicoRepository.save(novoTecnico);
        return toDTO(novoTecnico);
    }

    public TecnicoResponseDTO consultarTecnico(String idTecnico) {
        Tecnico tecnico = tecnicoRepository.findById(idTecnico)
                .orElseThrow(()-> new RuntimeException("Tecnico não encontrado"));

        return toDTO(tecnico);
    }

    public List<ExameResponseDTO> consultarExamesResponsavel(String idTecnico){
        Tecnico tecnico = tecnicoRepository.findById(idTecnico)
                .orElseThrow(()-> new RuntimeException("Tecnico não encontrado"));

        return tecnico.getExamesResponsavel()
                .stream()
                .map(ExameMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void atualizarResultado(String idTecnico,String idExame, String novoResultado){
        Tecnico tecnico = tecnicoRepository.findById(idTecnico)
                .orElseThrow(()-> new RuntimeException("Tecnico não encontrado"));

        Exame exame = exameRepository.findById(idExame)
                .orElseThrow(()-> new RuntimeException("Exame não encontrado"));

        if(!exame.getTecnicoResponsavel().getIdTecnico().equals(tecnico.getIdTecnico())){
            throw new RuntimeException("Você não tem permissão para atualizar este exame.");
        }

        String resultadoAtual = exame.getResultado();

        if(resultadoAtual == null || resultadoAtual.isBlank()){
            exame.setResultado("\n\n --ATUALIZADO EM :" + formatarDataString(LocalDate.now()) + "--\n" + novoResultado);
        } else {
            exame.setResultado(resultadoAtual + "\n\n --ATUALIZADO EM :" + formatarDataString(LocalDate.now()) + "--\n" + novoResultado);
        }

        exameRepository.save(exame);
    }

    public void desativarTecnico(String idTecnico){
        Tecnico tecnico = tecnicoRepository.findById(idTecnico)
                .orElseThrow(()-> new RuntimeException("Tecnico não encontrado"));

        boolean tecnicoAtivo = tecnico.getCadastroAtivo();

        if(!tecnicoAtivo){
            throw new RuntimeException("Tecnico já tem cadastros desativado");
        }

        tecnico.setCadastroAtivo(false);
        tecnicoRepository.save(tecnico);
    }


    private String formatarRegistroProfissional(EspecialidadeTecnica especialidade, String numeroRegistroProfissional){
        String sufixo = especialidade.getConselho();
        return String.format("%s - %s", numeroRegistroProfissional, sufixo);
    }

}
