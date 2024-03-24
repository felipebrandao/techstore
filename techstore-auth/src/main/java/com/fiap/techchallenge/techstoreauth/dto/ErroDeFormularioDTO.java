package com.fiap.techchallenge.techstoreauth.dto;

import lombok.Data;

@Data
public class ErroDeFormularioDTO {

    private String campo;
    private String erro;

    public ErroDeFormularioDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
