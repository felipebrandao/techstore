package com.fiap.techchallenge.techstoreitens.service.impl;

import com.fiap.techchallenge.techstoreitens.exception.ItemNaoEncontradoException;
import com.fiap.techchallenge.techstoreitens.model.Item;
import com.fiap.techchallenge.techstoreitens.repository.ItemRepository;
import com.fiap.techchallenge.techstoreitens.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item obterItemPorId(UUID id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNaoEncontradoException("Item com ID " + id + " não encontrada."));
        return item;
    }

    @Override
    public Item criarItem(Item item) {
        Item itemCriado = itemRepository.save(item);
        return itemCriado;
    }

    @Override
    public Item atualizarItem(UUID id, Item item) {
        // Implementação para atualizar um item existente
        return null;
    }

    @Override
    public void excluirItem(UUID id) {
        itemRepository.deleteById(id);
    }
}
