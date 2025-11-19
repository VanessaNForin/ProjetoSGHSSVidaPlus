package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.TecnicoInputDTO;
import com.forin.apividaplus.dtos.TecnicoResponseDTO;
import com.forin.apividaplus.models.pessoas.Tecnico;
import static com.forin.apividaplus.services.Utils.formatarDataString;

public class TecnicoMapper {

    public static Tecnico toModel(TecnicoInputDTO tecnico){
        Tecnico novoTecnico = new Tecnico();

        novoTecnico.setNomeCompleto(tecnico.getNomeCompleto());
        novoTecnico.setCpf(tecnico.getCpf());
        novoTecnico.setEndereco(tecnico.getEndereco());
        novoTecnico.setTelefone(tecnico.getTelefone());
        novoTecnico.setEspecialidade(tecnico.getEspecialidadeTecnica());

        return novoTecnico;
    }

    public static TecnicoResponseDTO toDTO(Tecnico tecnico){
        TecnicoResponseDTO novoTecnicoResponse = new TecnicoResponseDTO();

        novoTecnicoResponse.setIdTecnico(tecnico.getIdTecnico());
        novoTecnicoResponse.setNomeCompleto(tecnico.getNomeCompleto());
        novoTecnicoResponse.setDataNascimento(formatarDataString(tecnico.getDataNascimento()));
        novoTecnicoResponse.setCpf(tecnico.getCpf());
        novoTecnicoResponse.setEndereco(tecnico.getEndereco());
        novoTecnicoResponse.setTelefone(tecnico.getTelefone());
        novoTecnicoResponse.setEspecialidade(tecnico.getEspecialidade().getEspecialidade());
        novoTecnicoResponse.setRegistroProfissional(tecnico.getRegistroProfissional());

        return novoTecnicoResponse;

    }
}
