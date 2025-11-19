package com.forin.apividaplus.dtos;

import com.forin.apividaplus.models.enums.CategoriaExame;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LaboratorioInputDTO {

    @NotBlank(message = "O campo NOME é obrigatório")
    private String nome;

    @NotBlank(message = "O campo ENDEREÇO é obrigatório")
    private String endereco;

    @NotBlank(message = "O campo TELEFONE é obrigatório")
    @Pattern(regexp = "^\\(?[1-9]{2}\\)?\\s?9?\\d{4}-?\\d{4}$", message = "Formato de telefone inválido")
    private String telefone;

    @NotNull(message = "O campo TIPO DE EXAME OFERTADO é obrigatório")
    private CategoriaExame tipoExameOfertado;

}
