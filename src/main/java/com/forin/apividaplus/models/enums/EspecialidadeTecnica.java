package com.forin.apividaplus.models.enums;

public enum EspecialidadeTecnica {

    LABORATORIAL("CRBM"),
    EXAMES_IMAGEM("CRTR"),
    OUTRO("OUTRO");

    private final String conselho;

    EspecialidadeTecnica(String conselho){
        this.conselho = conselho;
    }

    public String getConselho(){
        return conselho;
    }
}
