package com.forin.apividaplus.models.pessoas;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class Pessoa {

    @Column(name = "nome_completo", nullable = false, length = 50)
    private String nomeCompleto;

    @Column(name = "data_de_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "telefone", length = 12)
    private String telefone;

    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;
}
