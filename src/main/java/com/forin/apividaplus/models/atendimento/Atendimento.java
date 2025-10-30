package com.forin.apividaplus.models.atendimento;

import com.forin.apividaplus.models.utils.Unidade;
import com.forin.apividaplus.models.pessoa.Paciente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "local", nullable = false)
    @Enumerated(EnumType.STRING)
    private Unidade local;

}
