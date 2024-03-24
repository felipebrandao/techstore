package com.fiap.techchallenge.techstoreitens.service.impl;

import com.fiap.techchallenge.techstoreitens.exception.ItemNaoEncontradoException;
import com.fiap.techchallenge.techstoreitens.model.Item;
import com.fiap.techchallenge.techstoreitens.repository.ItemRepository;
import com.fiap.techchallenge.techstoreitens.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        item.setId(UUID.randomUUID());
        Item itemCriado = itemRepository.save(item);
        return itemCriado;
    }

    @Override
    public Item atualizarItem(UUID id, Item item) {
        itemRepository.findById(id)
                .ifPresentOrElse(
                        itemSalvo -> {
                            itemSalvo.setDescricao(item.getDescricao());
                            itemSalvo.setPreco(item.getPreco());
                            itemRepository.save(itemSalvo);
                        },
                        () -> {
                            throw new ItemNaoEncontradoException("Item com ID " + id + " não encontrada.");
                        }
                );
        return item;
    }

    @Override
    public void excluirItem(UUID id) {
        itemRepository.findById(id).ifPresentOrElse(
                item -> itemRepository.delete(item),
                () -> {
                    throw new ItemNaoEncontradoException("Item com ID " + id + " não encontrada.");
                });
    }

    @Override
    public List<Item> carregarListaDeItens() {
        return itemRepository.findAll();
    }
}
