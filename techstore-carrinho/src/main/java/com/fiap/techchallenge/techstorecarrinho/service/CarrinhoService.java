package com.fiap.techchallenge.techstorecarrinho.service;

import com.fiap.techchallenge.techstorecarrinho.model.Carrinho;
import com.fiap.techchallenge.techstorecarrinho.model.ItemCarrinho;

import java.util.UUID;

public interface CarrinhoService {

    void adicionarItemCarrinho(ItemCarrinho itemCarrinho);
    void removerItemCarrinho(UUID idItem);
    Carrinho obterCarrinho();
    void atualizarCarrinho(Carrinho carrinho);

}
