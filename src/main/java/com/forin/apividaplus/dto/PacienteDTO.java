package com.forin.apividaplus.dto;

import com.forin.apividaplus.models.utils.Convenio;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.List;

@Data
public class PacienteDTO {

    @NotBlank(message = "O campo NOME é obrigatório")
    private String nome;

    @NotBlank(message = "O campo CPF é obrigatório")
    private String cpf;

    @PastOrPresent(message = "A data de nascimento não pode ser no futuro")
    @NotBlank(message = "O campo DATA DE NASCIMENTO é obrigatório")
    private LocalDate dataNascimento;

    private String endereco;

    @Length(min = 10, max = 11)
    @NotBlank(message = "O campo TELEFONE é obrigatório")
    private String telefone;

    @Email(regexp = "^(.+)@(\\S+)$")
    private String email;

    @NotBlank(message = "O campo CONVENIO é obrigatório")
    private Convenio convenio;

    private List<String> alergias;

    private String profissao;

    private String contatoEmergencia;

}
