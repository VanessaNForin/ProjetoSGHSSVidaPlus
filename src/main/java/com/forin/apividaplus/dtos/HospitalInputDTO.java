package com.forin.apividaplus.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HospitalInputDTO {

    @NotBlank(message = "O campo NOME é obrigatório")
    private String nome;

    @NotBlank(message = "O campo ENDERECO é obrigatório")
    private String endereco;

    @NotBlank(message = "O campo TELEFONE é obrigatório")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres")
    @Pattern(regexp = "^\\(?[1-9]{2}\\)?\\s?9?\\d{4}-?\\d{4}$", message = "Formato de telefone inválido")
    private String telefone;

}
