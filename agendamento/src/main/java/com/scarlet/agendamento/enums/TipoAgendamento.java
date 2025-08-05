package com.scarlet.agendamento.enums;

public enum TipoAgendamento {
    ESPECIALIDADE("especialidade"),
    PROFISSIONAL("profissional");

    private final String chave;

    TipoAgendamento(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }
}