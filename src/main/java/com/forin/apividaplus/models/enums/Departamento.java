package com.forin.apividaplus.models.enums;


public enum Departamento {

    RH("Recursos Humanos"),
    FINANCEIRO("Financeiro"),
    CONTABILIDADE("Contabilidade"),
    FISCAL("Fiscal"),
    COMPRAS("Compras / Suprimentos"),
    ALMOXARIFADO("Almoxarifado / Estoque"),
    JURIDICO("Jurídico"),
    CONTROLADORIA("Controladoria"),
    PLANEJAMENTO_ESTRATEGICO("Planejamento Estratégico"),
    MARKETING("Marketing"),
    COMERCIAL("Comercial / Vendas"),
    ATENDIMENTO("Atendimento / SAC"),
    TI("Tecnologia da Informação"),
    LOGISTICA("Logística"),
    ADMINISTRACAO_GERAL("Administração Geral");

    private final String descricao;

    Departamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
