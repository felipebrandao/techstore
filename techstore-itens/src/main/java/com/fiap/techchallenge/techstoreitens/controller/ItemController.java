package com.fiap.techchallenge.techstoreitens.controller;

import com.fiap.techchallenge.techstoreitens.exception.UsuarioSemPermissaoException;
import com.fiap.techchallenge.techstoreitens.model.Item;
import com.fiap.techchallenge.techstoreitens.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> obterItemPorId(@PathVariable UUID id) {
        Item item = itemService.obterItemPorId(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> criarItem(@RequestBody Item item, HttpServletRequest request) {
        verificarPermissao(request.getHeader("role"));
        Item itemCriado = itemService.criarItem(item);
        return new ResponseEntity<>(itemCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable UUID id, @RequestBody Item item, HttpServletRequest request) {
        verificarPermissao(request.getHeader("role"));
        Item itemAtualizado = itemService.atualizarItem(id, item);
        return new ResponseEntity<>(itemAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirItem(@PathVariable UUID id, HttpServletRequest request) {
        verificarPermissao(request.getHeader("role"));
        itemService.excluirItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Item>> carregarListaDeItens() {
        List<Item> listaDeItens = itemService.carregarListaDeItens();
        return new ResponseEntity<>(listaDeItens, HttpStatus.OK);
    }

    private void verificarPermissao(String role) {
        if (!"ADMINISTRADOR".equals(role)) {
            throw new UsuarioSemPermissaoException("Usuário sem permissão no módulo de item");
        }
    }

}
