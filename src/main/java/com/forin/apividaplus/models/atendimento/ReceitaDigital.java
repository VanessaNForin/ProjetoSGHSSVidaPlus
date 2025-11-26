package com.forin.apividaplus.models.atendimento;

import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.models.pessoas.Paciente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "receitas")
@Data
public class ReceitaDigital {

    @Id
    @Column(name = "identificador_receita",unique = true)
    private String idReceita;

    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consultaEmissao;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medicoEmissor;

    @Lob
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;
}
