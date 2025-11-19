package com.forin.apividaplus.models.enums;

import lombok.Getter;

@Getter
public enum EspecialidadeTecnica {

    LABORATORIAL("CRBM", "Laboratorial", CategoriaExame.LABORATORIAL),
    EXAMES_IMAGEM("CRTR", "Exames de Imagem", CategoriaExame.IMAGEM);

    private final String conselho;
    private final String especialidade;
    private final CategoriaExame categoriaExame;

    EspecialidadeTecnica(String conselho, String especialidade, CategoriaExame categoriaExame){
        this.conselho = conselho;
        this.especialidade = especialidade;
        this.categoriaExame = categoriaExame;
    }

}
