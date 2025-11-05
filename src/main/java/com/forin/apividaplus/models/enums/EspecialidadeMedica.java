package com.forin.apividaplus.models.enums;

public enum EspecialidadeMedica {

    CLINICO_GERAL("Clínico Geral / Medicina de Família e Comunidade"),
    CARDIOLOGIA("Cardiologia"),
    PEDIATRIA("Pediatria"),
    GINECOLOGIA_OBSTETRICIA("Ginecologia e Obstetrícia"),
    DERMATOLOGIA("Dermatologia"),
    ORTOPEDIA_TRAUMATOLOGIA("Ortopedia e Traumatologia"),
    OFTALMOLOGIA("Oftalmologia"),
    OTORRINOLARINGOLOGIA("Otorrinolaringologia"),
    PSIQUIATRIA("Psiquiatria"),
    NEUROLOGIA("Neurologia"),
    ENDOCRINOLOGIA("Endocrinologia"),
    GASTROENTEROLOGIA("Gastroenterologia"),
    PNEUMOLOGIA("Pneumologia"),
    NEFROLOGIA("Nefrologia"),
    HEMATOLOGIA("Hematologia"),
    ONCOLOGIA("Oncologia"),
    REUMATOLOGIA("Reumatologia"),
    INFECTOLOGIA("Infectologia"),
    UROLOGIA("Urologia");

    private final String descricao;

    EspecialidadeMedica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
