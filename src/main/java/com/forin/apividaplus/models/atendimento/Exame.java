package com.forin.apividaplus.models.atendimento;

import com.forin.apividaplus.models.pessoa.ProfissionalSaude;
import com.forin.apividaplus.models.utils.TipoExame;
import jakarta.persistence.*;

@Entity
@Table(name = "exames")
public class Exame extends Atendimento{

    @ManyToOne
    @JoinColumn(name = "id_tecnico", nullable = false)
    private ProfissionalSaude profissional;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_exame")
    private TipoExame tipoExame;

    @Column(name = "resultado")
    private String resultadoExame; //Futura melhoria -> Ter a opcao de gerar um pdf

}
