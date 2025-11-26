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
    @Column(name = "identificador_exame",unique = true)
    private String idExame;

    @Column(name = "is_ativo")
    private Boolean isAtivo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_exame", nullable = false)
    private CategoriaExame categoriaExame;

    @ManyToOne
    @JoinColumn(name = "laboratorio_id", nullable = false)
    private Laboratorio laboratorio;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "tecnico_id", nullable = false)
    private Tecnico tecnicoResponsavel;

    @Lob
    @Column(name = "descricao_exame", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Lob
    @Column(name = "resultado_exame", columnDefinition = "TEXT")
    private String resultado;

}
