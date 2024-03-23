package com.fiap.techchallenge.techstorecarrinho.service.impl;

import com.fiap.techchallenge.techstorecarrinho.model.Carrinho;
import com.fiap.techchallenge.techstorecarrinho.model.ItemCarrinho;
import com.fiap.techchallenge.techstorecarrinho.service.CarrinhoService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    private final Carrinho carrinho = new Carrinho();

    @Override
    public void adicionarItemCarrinho(ItemCarrinho itemCarrinho) {

    }

    @Override
    public void removerItemCarrinho(UUID idItem) {

    }

    @Override
    public Carrinho obterCarrinho() {
        return null;
    }

    @Override
    public void atualizarCarrinho(Carrinho carrinho) {

    }
}
