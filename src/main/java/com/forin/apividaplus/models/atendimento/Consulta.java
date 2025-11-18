package com.forin.apividaplus.models.atendimento;

import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.models.enums.TipoConsulta;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.models.pessoas.Paciente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "consultas")
@Data
public class Consulta {

    @Id
    @Column(name = "identificador_consulta")
    private String idConsulta;

    @ManyToOne
    @JoinColumn(name = "clinica_id", nullable = false)
    private Clinica local;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(name = "tipo_consulta")
    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medicoResponsavel;

    @OneToMany(mappedBy = "consultaEmissao")
    @Column(name = "prescricoes")
    private List<ReceitaDigital> prescricoes;

}
