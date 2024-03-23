package com.fiap.techchallenge.techstorecarrinho.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Carrinho {

    private UUID id;
    private String username;
    private List<ItemCarrinho> itens = new ArrayList<>();

}
