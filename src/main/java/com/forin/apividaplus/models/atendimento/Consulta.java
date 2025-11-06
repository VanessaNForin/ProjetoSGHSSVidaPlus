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
    private String consulta;

    @ManyToOne
    @Column(name = "local", nullable = false)
    private Clinica local;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "tipo_consulta")
    private TipoConsulta tipoConsulta;

    @Column(name = "medico")
    private Medico medico;

    @OneToMany(mappedBy = "consultaEmissao")
    @Column(name = "prescricoes")
    private List<ReceitaDigital> prescricoes;

}
