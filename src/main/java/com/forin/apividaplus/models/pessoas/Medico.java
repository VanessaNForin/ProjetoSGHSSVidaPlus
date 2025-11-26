package com.forin.apividaplus.models.pessoas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.atendimento.ReceitaDigital;
import com.forin.apividaplus.models.enums.EspecialidadeMedica;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "medicos")
@Data
public class Medico extends Pessoa{

    @Id
    @Column(name = "identificador_medico", unique = true)
    private String idMedico;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private EspecialidadeMedica especialidadeMedica;

    @Column(name = "crm", nullable = false)
    private String crm;

    @OneToMany(mappedBy = "medicoResponsavel")
    private List<Consulta> consultasRealizadas;

    @OneToMany(mappedBy = "medicoResponsavel")
    @JsonManagedReference
    private List<Internacao> internacoesRealizadas;

    @OneToMany(mappedBy = "medicoEmissor")
    private List<ReceitaDigital> receitasEmitidas;

}
