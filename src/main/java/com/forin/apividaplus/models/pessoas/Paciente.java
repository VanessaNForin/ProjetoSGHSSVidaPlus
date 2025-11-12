package com.forin.apividaplus.models.pessoas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.atendimento.ReceitaDigital;
import com.forin.apividaplus.models.enums.Convenio;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente extends Pessoa{

    @Id
    @Column(name = "identificador_paciente")
    private String idPaciente;

    @Column(name = "profissao", length = 20)
    private String profissao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_convenio")
    private Convenio convenio;

    @Column(name = "contato_emergencia", length = 50)
    private String contatoEmergencia;

    @ElementCollection
    @CollectionTable(name = "paciente_alergia",
    joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "alergias")
    private List<String> alergias;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente")
    private List<Exame> exames;

    @OneToMany(mappedBy = "paciente")
    private List<ReceitaDigital> receitas;

    @OneToMany(mappedBy = "paciente")
    private List<Internacao> internacoes;

}
