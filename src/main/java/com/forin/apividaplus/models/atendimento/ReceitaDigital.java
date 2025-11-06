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
    @Column(name = "identificador_receita")
    private String idReceita;

    @ManyToOne
    @Column(name = "consulta_emissao")
    private Consulta consultaEmissao;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @ManyToOne
    @Column(name = "paciente")
    private Paciente paciente;

    @ManyToOne
    @Column(name = "medico_emissor")
    private Medico medicoEmissor;

    @Column(name = "descricao")
    private String descricao;
}
