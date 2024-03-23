package com.fiap.techchallenge.techstorecarrinho.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemCarrinho {

    private UUID idItem;

    private UUID idProduto;
    private String nomeProduto;
    private int quantidade;
    private BigDecimal preco;
}
