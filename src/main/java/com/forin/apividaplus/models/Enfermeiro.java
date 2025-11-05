package com.forin.apividaplus.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "enfermeiros")
public class Enfermeiro extends Pessoa{

    @Id
    @Column(name = "identificador_enfermeiro")
    private String idEnfermeiro;

    @Column(name = "hospital_trabalho")
    private Hospital hospitalTrabalho;

    @Column(name = "e_supervisora")
    private Boolean isSupervisora;

    @Column(name = "e_plantonista")
    private Boolean isPlantonista;

    @Column(name = "coren", nullable = false)
    private String coren;

    @OneToMany(mappedBy = "enfermeiroResponsavel")
    private List<Interncao> interncaosResponsavel;

}
