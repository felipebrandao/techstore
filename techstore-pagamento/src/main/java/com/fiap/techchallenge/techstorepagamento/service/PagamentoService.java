package com.fiap.techchallenge.techstorepagamento.service;

import com.fiap.techchallenge.techstorepagamento.dto.CarrinhoDTO;

import java.util.UUID;

public interface PagamentoService {

    CarrinhoDTO simularPagamento(CarrinhoDTO carrinhoDTO);
    void processarPagamento(UUID idPedido, CarrinhoDTO carrinhoDTO);
}
