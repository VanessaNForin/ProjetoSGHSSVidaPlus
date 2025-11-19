package com.forin.apividaplus.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.forin.apividaplus.models.enums.CategoriaExame;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ExameInputDTO {

    @NotBlank(message = "O campo PACIENTE é obrigatório")
    private String idPaciente;

    @NotNull(message = "O campo CATEGORIA DE EXAME é obrigatório")
    private CategoriaExame categoriaExame;

    @NotBlank(message = "O campo LABORATÓRIO é obrigatório")
    private String idLaboratorio;

    @NotBlank(message = "O campo DATA E HORA é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[1-2])/(19\\d{2}|20\\d{2}|2100) ([0-1][0-9]|2[0-3]):([0-5][0-9])$", message = "Formato inválido")
    private String dataHora;

    @NotBlank(message = "O campo TECNICO é obrigatório")
    private String idTecnicoResponsavel;

    @NotBlank(message = "O campo DESCRIÇÃO é obrigatório")
    private String descricao;
}
