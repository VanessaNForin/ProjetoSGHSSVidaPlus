package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class ReceitaDigitalResponseDTO {

    private String idReceita;
    private String consultaEmissao;
    private String dataEmissao;
    private String dataVencimento;
    private String paciente;
    private String medicoEmissor;
    private String descricao;
}
