package com.forin.apividaplus.models.infraestrutura;

import com.forin.apividaplus.models.enums.CategoriaExame;
import com.forin.apividaplus.models.pessoas.Administrador;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "laboratorios")
@Data
public class Laboratorio {

    @Id
    @Column(name = "identificador_laboratório")
    private String idLaboratorio;

    @Column(name = "is_ativo")
    private Boolean isAtivo;

    @Column(name = "nome_laboratorio", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_exame_ofertado", nullable = false)
    private CategoriaExame tipoExameOfertado;

    @ManyToMany(mappedBy = "laboratorios")
    private List<Administrador> administradores;


}
