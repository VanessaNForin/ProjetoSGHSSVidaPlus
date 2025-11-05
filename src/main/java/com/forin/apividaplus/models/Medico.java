package com.forin.apividaplus.models;

import com.forin.apividaplus.models.enums.EspecialidadeMedica;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicos")
public class Medico extends Pessoa{

    @Id
    @Column(name = "identificador_medico")
    private String idMedico;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private EspecialidadeMedica especialidadeMedica;

    @Column(name = "crm", nullable = false)
    private String crm;

    @OneToMany(mappedBy = "medicoResponsavel")
    private List<Consulta> consultasRealizadas;

    @OneToMany(mappedBy = "medicoResponsavel")
    private List<Internacao> internacoesRealizadas;

    @OneToMany(mappedBy = "medicoEmissor")
    private List<ReceitaDigital> receitasEmitidas;


}
