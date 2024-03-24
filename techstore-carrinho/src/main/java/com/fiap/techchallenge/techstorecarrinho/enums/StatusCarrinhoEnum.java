package com.fiap.techchallenge.techstorecarrinho.enums;

public enum StatusCarrinhoEnum {

    ABERTO("Aberto"),
    PAGO("Pago");

    private String tipoStatus;

    StatusCarrinhoEnum(String tipoStatus) {
        this.tipoStatus = tipoStatus;
    }

    public String getTipoStatus() {
        return tipoStatus;
    }
}
