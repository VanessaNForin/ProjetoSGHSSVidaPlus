package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class LaboratorioResponseDTO {

    private String idLaboratorio;
    private Boolean isAtivo;
    private String nome;
    private String endereco;
    private String telefone;
    private String tipoExameOfertado;
}
