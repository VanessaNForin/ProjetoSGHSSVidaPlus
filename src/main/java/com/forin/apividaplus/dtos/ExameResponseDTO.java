package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class ExameResponseDTO {

    private String idExame;
    private String isAtivo;
    private String paciente;
    private String laboratorio;
    private String dataHora;
    private String tecnicoResponsavel;
    private String categoriaExame;
    private String descricao;
    private String resultado;
}
