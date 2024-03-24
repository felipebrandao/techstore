package com.fiap.techchallenge.techstorecarrinho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carrinho")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Carrinho {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "carrinho", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(ItemCarrinho itemCarrinho) {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(itemCarrinho);
    }

    public void removerItem(UUID idItem) {
        if (itens != null) {
            itens.removeIf(item -> item.getId().equals(idItem));
        }
    }
}
