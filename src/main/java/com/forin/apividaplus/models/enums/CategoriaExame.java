package com.forin.apividaplus.models.enums;

import lombok.Getter;

@Getter
public enum CategoriaExame {

    LABORATORIAL("Exames de Sangue, Urina, Fezes, Antibiograma, Imunológicos, Sorologias, Genéticos e Outros", "Exame Laboratorial"),
    IMAGEM("Exames de Radiografia, Ultrassonografia, Tomografia, Ressonância, Mamografia e Outros", "Exame de Imagem");

    private final String descricao;
    private final String descricaoCurta;

    CategoriaExame(String descricao, String descricaoCurta) {
        this.descricao = descricao;
        this.descricaoCurta = descricaoCurta;
    }

}
