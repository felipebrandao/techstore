package com.fiap.techchallenge.techstorecarrinho.service;

import com.fiap.techchallenge.techstorecarrinho.feign.dto.ItemDTO;
import com.fiap.techchallenge.techstorecarrinho.model.Carrinho;
import com.fiap.techchallenge.techstorecarrinho.model.ItemCarrinho;

import java.util.UUID;

public interface CarrinhoService {

    Carrinho adicionarItemCarrinho(ItemCarrinho itemCarrinho, String username, ItemDTO itemDTO);
    void removerItemCarrinho(UUID idItem, String username);
    Carrinho obterCarrinho(String username);

    Carrinho obterCarrinhoPorId(UUID id);

    Carrinho pagamentoCarrinhoPorId(UUID id);
}
