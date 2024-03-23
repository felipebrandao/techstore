package com.fiap.techchallenge.techstoreitens.service;

import com.fiap.techchallenge.techstoreitens.model.Item;

import java.util.UUID;

public interface ItemService {

    Item obterItemPorId(UUID id);
    Item criarItem(Item item);
    Item atualizarItem(UUID id, Item item);
    void excluirItem(UUID id);

}
