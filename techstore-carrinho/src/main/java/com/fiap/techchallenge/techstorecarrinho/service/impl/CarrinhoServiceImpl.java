package com.fiap.techchallenge.techstorecarrinho.service.impl;

import com.fiap.techchallenge.techstorecarrinho.feign.dto.ItemDTO;
import com.fiap.techchallenge.techstorecarrinho.model.Carrinho;
import com.fiap.techchallenge.techstorecarrinho.model.ItemCarrinho;
import com.fiap.techchallenge.techstorecarrinho.repository.CarrinhoRepository;
import com.fiap.techchallenge.techstorecarrinho.service.CarrinhoService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;


    public CarrinhoServiceImpl(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    public Carrinho adicionarItemCarrinho(ItemCarrinho itemCarrinho, String username, ItemDTO itemDTO) {
        Carrinho carrinho = obterCarrinho(username);

        if (carrinho == null) {
            carrinho = new Carrinho();
            carrinho.setUsername(username);
        }

        Optional<ItemCarrinho> itemExistente = carrinho.getItens().stream()
                .filter(item -> item.getIdProduto().equals(itemCarrinho.getIdProduto()))
                .findFirst();

        if (itemExistente.isPresent()) {
            ItemCarrinho itemCarrinhoExistente = itemExistente.get();
            int novaQuantidade = itemCarrinhoExistente.getQuantidade() + itemCarrinho.getQuantidade();
            itemCarrinhoExistente.setQuantidade(novaQuantidade);
        } else {
            itemCarrinho.setNomeProduto(itemDTO.getDescricao());
            itemCarrinho.setPreco(itemDTO.getPreco());
            itemCarrinho.setId(UUID.randomUUID());
            itemCarrinho.setIdCarrinho(carrinho.getId());
            carrinho.adicionarItem(itemCarrinho);
        }

        return carrinhoRepository.save(carrinho);

    }

    @Override
    public void removerItemCarrinho(UUID idItem, String username) {
        Carrinho carrinho = obterCarrinho(username);

        if (carrinho != null) {
            carrinho.removerItem(idItem);
            carrinhoRepository.save(carrinho);
        }
    }

    @Override
    public Carrinho obterCarrinho(String usuarioLogado) {
        Carrinho carrinho = carrinhoRepository.findByUsername(usuarioLogado);
        if(carrinho == null){
            carrinho = new Carrinho();
            carrinho.setId(UUID.randomUUID());
            carrinho.setUsername(usuarioLogado);
            carrinho = carrinhoRepository.save(carrinho);
        }
        return carrinho;
    }

}
