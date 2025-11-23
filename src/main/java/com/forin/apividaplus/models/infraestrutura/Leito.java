package com.forin.apividaplus.models.infraestrutura;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.forin.apividaplus.models.atendimento.Internacao;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "leitos")
@Data
public class Leito {

    @Id
    @Column(name = "identificador_leito")
    private String idLeito;

    @Column(name = "is_ativo")
    private Boolean isAtivo;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    @JsonBackReference
    private Hospital hospital;

    @Column(name = "andar", nullable = false)
    private Integer andar;

    @Column(name = "numero_leito", nullable = false)
    private Integer numeroLeito;

    @OneToMany(mappedBy = "leito")
    @JsonManagedReference
    private List<Internacao> internacao;

}
