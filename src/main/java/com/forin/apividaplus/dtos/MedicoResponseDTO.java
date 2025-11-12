package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class MedicoResponseDTO {

    private String idMedico;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String especialidadeMedica;
    private String crm;

}
