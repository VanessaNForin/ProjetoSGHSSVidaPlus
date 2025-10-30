package com.forin.apividaplus.models.pessoa;

import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.models.receita.ReceitaDigital;
import com.forin.apividaplus.models.utils.Convenio;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente extends Pessoa {

    @Column(name = "identificador_paciente", unique = true)
    private String identificadorPaciente;

    @Column(name = "convenio", nullable = false)
    @Enumerated(EnumType.STRING) //salva corretamente no banco
    private Convenio convenio;

    @ElementCollection //Cria uma tabela auxiliar sem precisar de uma entidade nova
    @CollectionTable(
            //nome da tabela
            name = "paciente_alergias",
            //define a chave estrangeira que conecta essa tabela com paciente
            joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "alergias")
    private List<String> alergias;

    @Column(name = "profissao")
    private String profissao;

    @Column(name = "contato_emergencia")
    private String contatoEmergencia;

    //Relação com outras entidades
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente")
    private List<ReceitaDigital> receitas;

    @OneToMany(mappedBy = "paciente")
    private List<Exame> exames;

}
