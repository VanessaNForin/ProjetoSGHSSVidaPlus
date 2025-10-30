package com.forin.apividaplus.models.pessoa;

import com.forin.apividaplus.models.utils.Unidade;
import com.forin.apividaplus.models.utils.Cargo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "administradores")
@Data
public class Administrador extends Pessoa {

    @Column(name = "identificador_administrador", unique = true)
    private String identificadorAdm;

    @Column(name = "cargo")
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Column(name = "unidade")
    @Enumerated(EnumType.STRING)
    private Unidade unidadeTrabalho;



}
