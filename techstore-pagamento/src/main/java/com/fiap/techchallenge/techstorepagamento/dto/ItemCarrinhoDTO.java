package com.fiap.techchallenge.techstorepagamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemCarrinhoDTO {

    private UUID id;
    private UUID idProduto;
    private String nomeProduto;
    private int quantidade;
    private BigDecimal preco;

}
