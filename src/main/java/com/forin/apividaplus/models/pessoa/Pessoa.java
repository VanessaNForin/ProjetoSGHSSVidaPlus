package com.forin.apividaplus.models.pessoa;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;

}
