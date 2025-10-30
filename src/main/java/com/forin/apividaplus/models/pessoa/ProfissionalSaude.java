package com.forin.apividaplus.models.pessoa;

import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.models.utils.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "profissionais_saude")
@Data
public class ProfissionalSaude extends Pessoa {

    @Column(name = "identificador_profissional_saude", unique = true)
    private String identificadorProfissionalSaude;

    @Column(name = "tipo_profissional", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoProfissional tipoProfissional;

    @Column(name = "unidade_trabalho")
    @Enumerated(EnumType.STRING)
    private Unidade unidadeTrabalho;

    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Column(name = "conselho_profissional", nullable = false)
    @Enumerated(EnumType.STRING)
    private Conselho conselhoProfissional;

    @Column(name = "registro_profissional", nullable = false, length = 6)
    private String registroProfissional;

    @Column(name = "plantonista?")
    private Boolean isPlantonista;

    @Column(name = "supervisor?")
    private Boolean isSupervisor;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "profissional")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "profissional")
    private List<Exame> exames;




}
