package com.forin.apividaplus.models.atendimento;

import com.forin.apividaplus.models.pessoa.ProfissionalSaude;
import com.forin.apividaplus.models.receita.ReceitaDigital;
import com.forin.apividaplus.models.utils.TipoConsulta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "consultas")
@Data
public class Consulta extends Atendimento {

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private ProfissionalSaude profissional;

    @Column(name = "tipo_consulta")
    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;

    @OneToMany(mappedBy = "consulta")
    private List<ReceitaDigital> prescricoes;

}
