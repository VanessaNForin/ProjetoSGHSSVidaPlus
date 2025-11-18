package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.ConsultaResponseDTO;
import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.services.Utils;

import java.util.stream.Collectors;

import static com.forin.apividaplus.services.Utils.formatarDataHoraString;

public class ConsultaMapper {

    public static ConsultaResponseDTO toDTO(Consulta consulta){
        ConsultaResponseDTO novaConsultaResponseDTO = new ConsultaResponseDTO();

        novaConsultaResponseDTO.setIdConsulta(consulta.getIdConsulta());
        novaConsultaResponseDTO.setLocal(consulta.getLocal().getNome());
        novaConsultaResponseDTO.setDataHora(formatarDataHoraString(consulta.getDataHora()));
        novaConsultaResponseDTO.setPaciente(consulta.getPaciente().getNomeCompleto());
        novaConsultaResponseDTO.setTipoConsulta(consulta.getTipoConsulta().getDescricao());
        novaConsultaResponseDTO.setMedicoResponsavel(consulta.getMedicoResponsavel().getNomeCompleto());
        novaConsultaResponseDTO.setPrescricoes(
                consulta.getPrescricoes()
                        .stream()
                        .map(ReceitaDigitalMapper::toDTO)
                        .collect(Collectors.toList())
        );

        return novaConsultaResponseDTO;
    }
}