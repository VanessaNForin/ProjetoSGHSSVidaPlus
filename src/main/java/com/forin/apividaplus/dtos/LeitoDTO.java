package com.forin.apividaplus.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeitoDTO {

    @NotBlank(message = "O campo ID HOSPITAL é obrigatório")
    private String idHospital;

    @NotNull(message = "O campo ANDAR é obrigatório")
    private Integer andar;

    @NotNull(message = "O campo NÚMERO DO LEITO é obrigatório")
    private Integer numeroLeito;
}
