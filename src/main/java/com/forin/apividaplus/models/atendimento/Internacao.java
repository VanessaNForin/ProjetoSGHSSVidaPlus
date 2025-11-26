package com.forin.apividaplus.models.atendimento;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.models.pessoas.Paciente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "internacoes")
@Data
public class Internacao {

    @Id
    @Column(name = "identificador_internacao",unique = true)
    private String idInternacao;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "leito_id", nullable = false)
    @JsonBackReference
    private Leito leito;

    @Column(name = "esta_ativo")
    private Boolean isAtivo;

    @Column(name = "data_entrada", nullable = false)
    private LocalDateTime dataEntrada;

    @Column(name = "data_alta")
    private LocalDateTime dataAlta;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @JsonBackReference
    private Medico medicoResponsavel;

    @ManyToOne
    @JoinColumn(name = "enfermeiro_id", nullable = false)
    @JsonBackReference
    private Enfermeiro enfermeiroResponsavel;

    @Lob
    @Column(name = "prontuario", columnDefinition = "TEXT")
    private String prontuario;

}
