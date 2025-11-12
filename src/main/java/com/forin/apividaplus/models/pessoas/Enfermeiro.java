package com.forin.apividaplus.models.pessoas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.models.atendimento.Internacao;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "enfermeiros")
@Data
public class Enfermeiro extends Pessoa{

    @Id
    @Column(name = "identificador_enfermeiro")
    private String idEnfermeiro;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospitalTrabalho;

    @Column(name = "e_supervisora")
    private Boolean isSupervisora;

    @Column(name = "e_plantonista")
    private Boolean isPlantonista;

    @Column(name = "coren", nullable = false)
    private String coren;

    @OneToMany(mappedBy = "enfermeiroResponsavel")
    @JsonManagedReference
    private List<Internacao> interncaosResponsavel;

}
