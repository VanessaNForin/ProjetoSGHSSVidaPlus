package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class LeitoResponseDTO {

    private String idLeito;
    private Boolean isAtivo;
    private String hospital;
    private Integer andar;
    private Integer numeroLeito;
    private String internacaoAtual;
}
