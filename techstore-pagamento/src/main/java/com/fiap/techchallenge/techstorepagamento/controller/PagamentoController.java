package com.fiap.techchallenge.techstorepagamento.controller;

import com.fiap.techchallenge.techstorepagamento.model.Pedido;
import com.fiap.techchallenge.techstorepagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/simular")
    public ResponseEntity<BigDecimal> simularPagamento(@RequestBody Pedido pedido) {
        // Lógica para simular o pagamento do pedido
        return null;
    }

    @PostMapping("/processar")
    public ResponseEntity<String> processarPagamento(@RequestBody Pedido pedido) {
        // Lógica para processar o pagamento do pedido
        return null;
    }

}
