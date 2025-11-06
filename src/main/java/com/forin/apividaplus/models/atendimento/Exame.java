package com.forin.apividaplus.models.atendimento;

import com.forin.apividaplus.models.enums.CategoriaExame;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.models.pessoas.Tecnico;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "exames")
@Data
public class Exame {

    @Id
    @Column(name = "identificador_exame")
    private String idExame;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "laboratorio_id", nullable = false)
    private Laboratorio laboratorio;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "tecnico_id", nullable = false)
    private Tecnico tecnicoResponsavel;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_exame", nullable = false)
    private CategoriaExame categoriaExame;

    @Column(name = "descricao_exame", nullable = false)
    private String descricao;

    @Column(name = "resultado_exame")
    private String resultado;

}
