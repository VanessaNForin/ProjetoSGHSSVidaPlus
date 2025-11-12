package com.forin.apividaplus.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InternacaoInputDTO {

    @NotBlank(message = "O campo PACIENTE é obrigatório")
    private String idPaciente;

    @NotBlank(message = "O campo LEITO é obrigatório")
    private String idLeito;

    @NotBlank(message = "O campo MÉDICO é obrigatório")
    private String idMedico;

    @NotBlank(message = "O campo ENFERMEIRO é obrigatório")
    private String idEnfermeiro;

}
