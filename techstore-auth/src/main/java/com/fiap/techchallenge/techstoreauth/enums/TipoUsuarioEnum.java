package com.fiap.techchallenge.techstoreauth.enums;

public enum TipoUsuarioEnum {

    CLIENTE("Cliente"),
    ADMINISTRADOR("Administrador");

    private String tipoUsuario;

    TipoUsuarioEnum(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
