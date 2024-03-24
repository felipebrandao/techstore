package com.fiap.techchallenge.techstorecarrinho.controller;

import com.fiap.techchallenge.techstorecarrinho.exception.UsuarioSemPermissaoException;
import com.fiap.techchallenge.techstorecarrinho.feign.ItemFeignClient;
import com.fiap.techchallenge.techstorecarrinho.feign.dto.ItemDTO;
import com.fiap.techchallenge.techstorecarrinho.model.Carrinho;
import com.fiap.techchallenge.techstorecarrinho.model.ItemCarrinho;
import com.fiap.techchallenge.techstorecarrinho.service.CarrinhoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {
    private final CarrinhoService carrinhoService;
    private final ItemFeignClient itemFeignClient;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService, ItemFeignClient itemFeignClient) {
        this.carrinhoService = carrinhoService;
        this.itemFeignClient = itemFeignClient;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Carrinho> adicionarItemCarrinho(@RequestBody ItemCarrinho itemCarrinho, HttpServletRequest request) {
        verificarPermissao(request.getHeader("role"));
        String username = request.getHeader("username");

        Map<String, String> headersMap = extrairHeaders(request);

        ItemDTO itemDTO = itemFeignClient.obterItemPorId(headersMap, itemCarrinho.getIdProduto());
        Carrinho carrinho = carrinhoService.adicionarItemCarrinho(itemCarrinho, username, itemDTO);
        return new ResponseEntity<>(carrinho, HttpStatus.CREATED);
    }

    @DeleteMapping("/remover/{idItem}")
    public ResponseEntity<Void> removerItemCarrinho(@PathVariable UUID idItem, HttpServletRequest request) {
        verificarPermissao(request.getHeader("role"));
        String username = request.getHeader("username");
        carrinhoService.removerItemCarrinho(idItem, username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Carrinho> obterCarrinho(HttpServletRequest request) {
        verificarPermissao(request.getHeader("role"));
        String username = request.getHeader("username");
        Carrinho carrinho = carrinhoService.obterCarrinho(username);
        return ResponseEntity.ok(carrinho);
    }

    private void verificarPermissao(String role) {
        if (!"CLIENTE".equals(role)) {
            throw new UsuarioSemPermissaoException("Usuário sem permissão no módulo de Carrinho");
        }
    }

    private Map<String, String> extrairHeaders(HttpServletRequest request) {
        Map<String, String> headersMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            List<String> headerValues = Collections.list(request.getHeaders(headerName));
            String headerValue = String.join(",", headerValues);
            headersMap.put(headerName, headerValue);
        }
        return headersMap;
    }
}
