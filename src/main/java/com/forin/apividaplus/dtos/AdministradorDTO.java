package com.forin.apividaplus.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.forin.apividaplus.models.enums.Departamento;
import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
public class AdministradorDTO {

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
    @Pattern(regexp = "^\\(?[1-9]{2}\\)?\\s?9?\\d{4}-?\\d{4}$", message = "Formato de telefone inválido")
    private String telefone;

    @NotBlank(message = "O campo DEPARTAMENTO é obrigatório")
    private Departamento departamento;
}
