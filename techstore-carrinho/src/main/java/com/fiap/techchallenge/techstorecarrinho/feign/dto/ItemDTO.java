package com.fiap.techchallenge.techstorecarrinho.feign.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemDTO {

    private UUID id;
    private String descricao;
    private BigDecimal preco;
}
