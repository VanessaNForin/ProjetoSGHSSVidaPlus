package com.forin.apividaplus.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ReceitaDigitalInputDTO {

    @NotBlank(message = "O campo CONSULTA é obrigatório")
    private String idConsulta;

    @Pattern(
            regexp = "^$|^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19\\d{2}|20\\d{2}|2100)$",
            message = "Formato inválido"
    )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataVencimento;

    @NotBlank(message = "O campo DESCRICAO é obrigatório")
    private String descricao;
}
