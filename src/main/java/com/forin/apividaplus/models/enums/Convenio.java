package com.forin.apividaplus.models.enums;

public enum Convenio {

    INDIVIDUAL("Individual"),
    FAMILIAR("Familiar"),
    EMPRESARIAL("Empresarial"),
    MEI("MEI"),
    PARTICULAR("Particular");

    private final String descricao;

    Convenio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
