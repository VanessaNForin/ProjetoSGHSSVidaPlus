package com.forin.apividaplus.models.pessoas;

import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.models.enums.EspecialidadeTecnica;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tecnicos")
@Data
public class Tecnico extends Pessoa{

    @Id
    @Column(name = "identificador_tecnico")
    private String idTecnico;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade_tecnica", nullable = false)
    private EspecialidadeTecnica especialidade;

    //Só existe eme memória, não é salvo no banco de dados
    @Transient
    private String numeroRegistroProfissional;

    @Column(name = "registro_profissional", nullable = false)
    private String registroProfissional;

    @OneToMany(mappedBy = "tecnicoResponsavel")
    private List<Exame> examesResponsavel;







}
