package com.forin.apividaplus.models.receita;

import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.pessoa.Paciente;
import com.forin.apividaplus.models.pessoa.ProfissionalSaude;
import com.forin.apividaplus.models.utils.TipoReceita;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "receitas_digitais")
public class ReceitaDigital {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private ProfissionalSaude medicoEmissor;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(name = "tipo_receita", nullable = false)
    private TipoReceita tipoReceita;

    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;
}
