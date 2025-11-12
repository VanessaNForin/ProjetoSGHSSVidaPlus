package com.forin.apividaplus.mappers;


import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.models.atendimento.Internacao;

import java.time.format.DateTimeFormatter;

public class InternacaoMapper {

    public static InternacaoResponseDTO toDTO(Internacao internacao){

        InternacaoResponseDTO novaInternacaoResponseDTO = new InternacaoResponseDTO();

        novaInternacaoResponseDTO.setIdInternacao(internacao.getIdInternacao());
        novaInternacaoResponseDTO.setPaciente(PacienteMapper.toDTO(internacao.getPaciente()));
        novaInternacaoResponseDTO.setLeito(internacao.getLeito().getIdLeito());

        String resposta;
        if (internacao.getIsAtivo() == true){
            resposta = "A Internação está ativa";
        } else {
            resposta = "O paciente já recebeu alta";
        }

        novaInternacaoResponseDTO.setIsAtivo(resposta);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        novaInternacaoResponseDTO.setDataEntrada(internacao.getDataEntrada().format(formatter));
        if (internacao.getDataAlta() != null) {
            novaInternacaoResponseDTO.setDataAlta(internacao.getDataAlta().format(formatter));
        }
        novaInternacaoResponseDTO.setMedicoResponsavel(internacao.getMedicoResponsavel().getNomeCompleto());
        novaInternacaoResponseDTO.setEnfermeiroResponsavel(internacao.getEnfermeiroResponsavel().getNomeCompleto());
        novaInternacaoResponseDTO.setProntuario(internacao.getProntuario());

        return novaInternacaoResponseDTO;
    }
}
