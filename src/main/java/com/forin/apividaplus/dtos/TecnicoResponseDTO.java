package com.forin.apividaplus.dtos;

import lombok.Data;

@Data
public class TecnicoResponseDTO {

    private String idTecnico;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String especialidade;
    private String registroProfissional;

}
