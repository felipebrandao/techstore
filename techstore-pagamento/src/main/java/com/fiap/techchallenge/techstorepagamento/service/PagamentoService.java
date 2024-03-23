package com.fiap.techchallenge.techstorepagamento.service;

import com.fiap.techchallenge.techstorepagamento.model.Pedido;

import java.math.BigDecimal;

public interface PagamentoService {

    BigDecimal simularPagamento(Pedido pedido);
    String processarPagamento(Pedido pedido);

}
