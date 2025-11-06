package com.forin.apividaplus.models.enums;

public enum TipoConsulta {

    ROTINA("Consulta de rotina"),
    RETORNO("Consulta de retorno"),
    URGENCIA("Consulta de urgência"),
    EMERGENCIA("Atendimento de emergência"),
    ESPECIALISTA("Avaliação com especialista"),
    ACOMPANHAMENTO("Consulta de acompanhamento de tratamento"),
    TELEMEDICINA("Consulta por telemedicina"),
    AVALIACAO_PREVENTIVA("Avaliação preventiva"),
    POS_OPERATORIO("Acompanhamento pós-operatório");

    private final String descricao;

    TipoConsulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
