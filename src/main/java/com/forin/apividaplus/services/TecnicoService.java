package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.TecnicoInputDTO;
import com.forin.apividaplus.dtos.TecnicoResponseDTO;
import com.forin.apividaplus.models.enums.EspecialidadeTecnica;
import com.forin.apividaplus.models.pessoas.Tecnico;
import com.forin.apividaplus.repositories.TecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.mappers.TecnicoMapper.toDTO;
import static com.forin.apividaplus.mappers.TecnicoMapper.toModel;
import static com.forin.apividaplus.services.Utils.*;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Transactional
    public Tecnico cadastrarTecnico(TecnicoInputDTO tecnico){
        Tecnico novoTecnico = toModel(tecnico);

        novoTecnico.setIdTecnico(criarId(Tecnico.class, tecnicoRepository.count()));
        novoTecnico.setCadastroAtivo(true);
        novoTecnico.setDataNascimento(validarDataNascimento(tecnico.getDataNascimento()));
        novoTecnico.setRegistroProfissional(formatarRegistroProfissional(tecnico.getEspecialidadeTecnica(),tecnico.getNumeroRegistroProfissional()));

        return tecnicoRepository.save(novoTecnico);
    }

    public TecnicoResponseDTO consultarTecnico(String idTecnico) {
        Tecnico tecnico = tecnicoRepository.findById(idTecnico)
                .orElseThrow(()-> new RuntimeException("Tecnico não encontrado"));

        return toDTO(tecnico);
    }

//    public void deletarTecnico(String idTecnico) {
//        tecnicoRepository.deleteById(idTecnico);
//    }

    private String formatarRegistroProfissional(EspecialidadeTecnica especialidade, String numeroRegistroProfissional){
        String sufixo = especialidade.getConselho();
        return String.format("%s - %s", numeroRegistroProfissional, sufixo);
    }

}
