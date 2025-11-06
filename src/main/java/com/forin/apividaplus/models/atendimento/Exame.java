package com.forin.apividaplus.models.atendimento;

import com.forin.apividaplus.models.enums.CategoriaExame;
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

    @Column(name = "paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @Column(name = "local", nullable = false)
    private Laboratorio laboratorio;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @Column(name = "tecnico_responsavel", nullable = false)
    private Tecnico tecnicoResponsavel;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_exame", nullable = false)
    private CategoriaExame categoriaExame;

    @Column(name = "descricao_exame", nullable = false)
    private String descricao;

    @Column(name = "resultado_exame")
    private String resultado;

}
