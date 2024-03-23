package com.fiap.techchallenge.techstorecarrinho.controller;

import com.fiap.techchallenge.techstorecarrinho.model.Carrinho;
import com.fiap.techchallenge.techstorecarrinho.model.ItemCarrinho;
import com.fiap.techchallenge.techstorecarrinho.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {
    private final CarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarItemCarrinho(@RequestBody ItemCarrinho itemCarrinho) {
        // Lógica para adicionar um item ao carrinho de compras
        return null;
    }

    @DeleteMapping("/remover/{idItem}")
    public ResponseEntity<?> removerItemCarrinho(@PathVariable Long idItem) {
        // Lógica para remover um item do carrinho de compras
        return null;
    }

    @GetMapping
    public ResponseEntity<Carrinho> obterCarrinho() {
        // Lógica para obter o carrinho de compras do usuário logado
        return null;
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarCarrinho(@RequestBody Carrinho carrinho) {
        // Lógica para atualizar o carrinho de compras com novos itens e/ou quantidades
        return null;
    }

}
