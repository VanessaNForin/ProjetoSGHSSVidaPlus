package com.forin.apividaplus.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.forin.apividaplus.models.enums.Convenio;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Data
public class PacienteDTO {

    @NotBlank(message = "O campo NOME COMPLETO é obrigatório")
    @Length(max = 50)
    private String nomeCompleto;

    @NotBlank(message = "O campo DATA DE NASCIMENTO é obrigatório")
    @PastOrPresent(message = "O campo DATA DE NASCIMENTO não pode ser no futuro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataNascimento;

    @NotBlank(message = "O campo CPF é obrigatório")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "Formato Inválido")
    @Length(min = 14, max = 14, message = "Quantidade de caracteres menor/igual ao padrão")
    private String cpf;

    @NotBlank(message = "O campo ENDEREÇO é obrigatório")
    private String endereco;

    @NotBlank(message = "O campo TELEFONE é obrigatório")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres")
    private String telefone;

    @NotBlank(message = "O campo PROFISSÃO é obrigatório")
    @Length(max = 20)
    private String profissao;

    @NotBlank(message = "O campo TIPO DE CONVÊNIO é obrigatório")
    private Convenio convenio;

    @Length(max = 50)
    private String contatoEmergencia;

    private List<String> alergias;

}
