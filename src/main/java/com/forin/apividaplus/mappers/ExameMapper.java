package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.ExameResponseDTO;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.services.Utils;

import static com.forin.apividaplus.services.Utils.formatarDataHoraString;

public class ExameMapper {

    public static ExameResponseDTO toDTO(Exame exame){
        ExameResponseDTO novoExameResponse = new ExameResponseDTO();

        novoExameResponse.setIdExame(exame.getIdExame());
        novoExameResponse.setPaciente(exame.getPaciente().getNomeCompleto());
        novoExameResponse.setLaboratorio(exame.getLaboratorio().getNome());
        novoExameResponse.setDataHora(formatarDataHoraString(exame.getDataHora()));
        novoExameResponse.setTecnicoResponsavel(exame.getTecnicoResponsavel().getNomeCompleto());
        novoExameResponse.setCategoriaExame(exame.getCategoriaExame().getDescricaoCurta());
        novoExameResponse.setDescricao(exame.getDescricao());
        novoExameResponse.setResultado(exame.getResultado());

        return novoExameResponse;
    }

}
