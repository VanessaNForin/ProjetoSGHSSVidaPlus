package com.forin.apividaplus.models.infraestrutura;

import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.pessoas.Administrador;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clinicas")
@Data
public class Clinica {

    @Id
    @Column(name = "identificador_clinica", unique = true)
    private String idClinica;

    @Column(name = "is_ativo")
    private Boolean isAtivo;

    @Column(name = "nome_clinica", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "local")
    private List<Consulta> consultas;

    @ManyToMany(mappedBy = "clinicas")
    private List<Administrador> administradores;
}
