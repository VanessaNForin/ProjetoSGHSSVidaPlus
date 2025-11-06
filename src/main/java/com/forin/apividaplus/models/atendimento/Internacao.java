package com.forin.apividaplus.models.atendimento;

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
    @Column(name = "identificador_internacao")
    private String internacao;

    @ManyToOne
    @Column(name = "paciente", nullable = false)
    private Paciente paciente;

    @OneToOne
    @Column(name = "leito", nullable = false)
    private Leito leito;

    @Column(name = "esta_ativo")
    private Boolean isAtivo;

    @Column(name = "data_entrada", nullable = false)
    private LocalDateTime dataEntrada;

    @Column(name = "data_alta")
    private LocalDateTime dataAlta;

    @ManyToOne
    @Column(name = "medico_responsavel", nullable = false)
    private Medico medicoResponsavel;

    @ManyToOne
    @Column(name = "enfermeiro_responsavel", nullable = false)
    private Enfermeiro enfermeiroResponsavel;

    @Column(name = "prontuario")
    private String prontuario;

}
