package com.forin.apividaplus.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AdministradorResponseDTO {

    private String idAdministrador;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String departamento;
    private List<String> hospitaisAdministrados;
    private List<String> laboratorioAdministrados;
    private List<String> clinicasAdministradas;

}
