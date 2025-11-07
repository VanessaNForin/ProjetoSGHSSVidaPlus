package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.TecnicoDTO;
import com.forin.apividaplus.models.enums.EspecialidadeTecnica;
import com.forin.apividaplus.models.pessoas.Tecnico;
import com.forin.apividaplus.repositories.TecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.formatarData;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Transactional
    public Tecnico cadastrarTecnico(TecnicoDTO tecnico){
        Tecnico novoTecnico = new Tecnico();

        novoTecnico.setIdTecnico(criarId(Tecnico.class, tecnicoRepository.count()));
        novoTecnico.setCadastroAtivo(true);
        novoTecnico.setNomeCompleto(tecnico.getNomeCompleto());
        novoTecnico.setDataNascimento(formatarData(tecnico.getDataNascimento()));
        novoTecnico.setCpf(tecnico.getCpf());
        novoTecnico.setEndereco(tecnico.getEndereco());
        novoTecnico.setTelefone(tecnico.getTelefone());
        novoTecnico.setEspecialidade(tecnico.getEspecialidadeTecnica());
        novoTecnico.setRegistroProfissional(formatarRegistroProfissional(tecnico.getEspecialidadeTecnica(),tecnico.getNumeroRegistroProfissional()));

        return tecnicoRepository.save(novoTecnico);
    }

    public Tecnico consultarTecnico(String idTecnico) {
        return tecnicoRepository.findById(idTecnico).orElseThrow(()-> new RuntimeException("Tecnico não encontrado"));
    }

    public void deletarTecnico(String idTecnico) {
        tecnicoRepository.deleteById(idTecnico);
    }

    private String formatarRegistroProfissional(EspecialidadeTecnica especialidade, String numeroRegistroProfissional){
        String sufixo = especialidade.getConselho();
        return String.format("%s - %s", numeroRegistroProfissional, sufixo);
    }

}
