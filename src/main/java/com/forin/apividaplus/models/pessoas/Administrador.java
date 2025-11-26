package com.forin.apividaplus.models.pessoas;

import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.models.enums.Departamento;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "administradores")
@Data
public class Administrador extends Pessoa{

    @Id
    @Column(name = "identificador_administrador", unique = true)
    private String idAdministrador;

    @Enumerated(EnumType.STRING)
    @Column(name = "departamento")
    private Departamento departamento;

    @ManyToMany //Varios Administradores podem Administrar Vários Hospitais
    @JoinTable(
            name = "administrador_hospital",
            joinColumns = @JoinColumn(name = "administrador_id"),
            inverseJoinColumns = @JoinColumn(name = "hospital_id")
    )
    private List<Hospital> hospitais;

    @ManyToMany
    @JoinTable(
            name = "administrador_clinica",
            joinColumns = @JoinColumn(name = "administrador_id"),
            inverseJoinColumns = @JoinColumn(name = "clinica_id")
    )
    private List<Clinica> clinicas;

    @ManyToMany
    @JoinTable(
            name = "administrador_laboratorio",
            joinColumns = @JoinColumn(name = "administrador_id"),
            inverseJoinColumns = @JoinColumn(name = "laboratorio_id")
    )
    private List<Laboratorio> laboratorios;
}
