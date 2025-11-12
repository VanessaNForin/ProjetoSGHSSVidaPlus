package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class EnfermeiroResponseDTO {

    private String idEnfermeiro;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String hospitalTrabalho;
    private String isSupervisora;
    private String isPlantonista;
    private String coren;



}
