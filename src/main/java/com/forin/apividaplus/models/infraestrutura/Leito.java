package com.forin.apividaplus.models.infraestrutura;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.forin.apividaplus.models.atendimento.Internacao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "leitos")
@Data
public class Leito {

    @Id
    @Column(name = "identificador_leito")
    private String idLeito;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    @JsonBackReference
    private Hospital hospital;

    @Column(name = "andar", nullable = false)
    private Integer andar;

    @Column(name = "numero_leito", nullable = false)
    private Integer numeroLeito;

    @OneToOne
    @JoinColumn(name = "internacao_id")
    private Internacao internacao;

}
