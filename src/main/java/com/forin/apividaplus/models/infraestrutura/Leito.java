package com.forin.apividaplus.models.infraestrutura;

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
    @Column(name = "hospital", nullable = false)
    private Hospital hospital;

    @Column(name = "andar", nullable = false)
    private Integer andar;

    @Column(name = "numero_leito", nullable = false)
    private Integer numeroLeito;

    @OneToOne
    @Column(name = "internacao")
    private Internacao internacao;

}
