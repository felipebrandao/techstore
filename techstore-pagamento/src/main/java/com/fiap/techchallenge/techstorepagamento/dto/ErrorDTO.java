package com.fiap.techchallenge.techstorepagamento.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ErrorDTO {
    private Instant timestamp;
    private int status;
    private String mensagem;

    public ErrorDTO(Instant timestamp, int status, String mensagem) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensagem = mensagem;
    }
}
