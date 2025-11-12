package com.forin.apividaplus.dtos;

import com.forin.apividaplus.models.enums.Convenio;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PacienteResponseDTO {

    private String idPaciente;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String profissao;
    private String convenio;
    private String contatoEmergencia;
    private List<String> alergias;

}
