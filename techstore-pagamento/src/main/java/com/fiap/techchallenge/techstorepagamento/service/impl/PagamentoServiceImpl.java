package com.fiap.techchallenge.techstorepagamento.service.impl;

import com.fiap.techchallenge.techstorepagamento.model.Pedido;
import com.fiap.techchallenge.techstorepagamento.service.PagamentoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Override
    public BigDecimal simularPagamento(Pedido pedido) {
        return null;
    }

    @Override
    public String processarPagamento(Pedido pedido) {
        return null;
    }
}
