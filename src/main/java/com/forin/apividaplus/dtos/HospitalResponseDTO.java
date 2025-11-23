package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class HospitalResponseDTO {

    private String idHospital;
    private boolean isAtivo;
    private String nome;
    private String endereco;
    private String telefone;

}
