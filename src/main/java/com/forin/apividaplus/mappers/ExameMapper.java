package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.ExameResponseDTO;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.services.Utils;

import java.time.LocalDateTime;

import static com.forin.apividaplus.services.Utils.formatarDataHoraString;

public class ExameMapper {

    public static ExameResponseDTO toDTO(Exame exame){
        ExameResponseDTO novoExameResponse = new ExameResponseDTO();

        novoExameResponse.setIdExame(exame.getIdExame());
        if (!exame.getIsAtivo()) {
            novoExameResponse.setIsAtivo("Exame Cancelado");
        }
        else if (exame.getDataHora().isAfter(LocalDateTime.now())) {
            novoExameResponse.setIsAtivo("Exame Agendado");
        }
        else {
            novoExameResponse.setIsAtivo("Exame Realizado");
        }
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
