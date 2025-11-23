package com.forin.apividaplus.dtos;

import com.forin.apividaplus.models.atendimento.ReceitaDigital;
import lombok.Data;

import java.util.List;

@Data
public class ConsultaResponseDTO {

    private String idConsulta;
    private String isAtiva;
    private String local;
    private String dataHora;
    private String paciente;
    private String tipoConsulta;
    private String medicoResponsavel;
    private List<ReceitaDigitalResponseDTO> prescricoes;
}
