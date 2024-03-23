package com.fiap.techchallenge.techstoreitens.controller;

import com.fiap.techchallenge.techstoreitens.model.Item;
import com.fiap.techchallenge.techstoreitens.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Item> criarItem(@RequestBody Item item) {
        Item itemCriado = itemService.criarItem(item);
        return new ResponseEntity<>(itemCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable Long id, @RequestBody Item item) {
        // Lógica para atualizar um item existente
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirItem(@PathVariable UUID id) {
        itemService.excluirItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
