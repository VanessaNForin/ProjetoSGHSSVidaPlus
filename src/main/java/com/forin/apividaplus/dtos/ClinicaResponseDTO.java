package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class ClinicaResponseDTO {

    private String idClinica;
    private Boolean isAtivo;
    private String nome;
    private String endereco;
    private String telefone;
}
