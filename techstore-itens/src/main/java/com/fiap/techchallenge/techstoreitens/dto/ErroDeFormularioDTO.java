package com.fiap.techchallenge.techstoreitens.dto;

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
