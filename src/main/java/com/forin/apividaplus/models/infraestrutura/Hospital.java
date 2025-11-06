package com.forin.apividaplus.models.infraestrutura;

import com.forin.apividaplus.models.pessoas.Administrador;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hospitais")
@Data
public class Hospital {

    @Id
    @Column(name = "identificador_hospital")
    private String idHospital;

    @Column(name = "nome_hospital", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "hospital")
    private List<Leito> leitos;

    @ManyToMany(mappedBy = "hospitais")
    private List<Administrador> administradores;
}
