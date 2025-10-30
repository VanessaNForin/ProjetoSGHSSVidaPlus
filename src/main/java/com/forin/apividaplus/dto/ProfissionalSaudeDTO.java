package com.forin.apividaplus.dto;

import com.forin.apividaplus.models.utils.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
public class ProfissionalSaudeDTO {

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

    @NotBlank(message = "O campo TIPO PROFISSIONAL é obrigatório")
    private TipoProfissional tipoProfissional;

    private Unidade unidadeTrabalho;

    private Turno turno;

    @NotBlank(message = "O campo CONSELHO PROFISSIONAL é obrigatório")
    private Conselho conselhoProfissional;

    @NotBlank(message = "O campo REGISTRO PROFISSIONAL é obrigatório")
    private String registroProfissional;

    private Boolean isPlantonista;

    private Boolean isSupervisor;

    @NotBlank(message = "O campo ESPECIALIDADE é obrigatório")
    private Especialidade especialidade;

}
