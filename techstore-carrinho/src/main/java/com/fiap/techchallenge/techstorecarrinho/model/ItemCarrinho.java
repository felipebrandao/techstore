package com.fiap.techchallenge.techstorecarrinho.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "item-carrinho")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemCarrinho {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "id_produto")
    private UUID idProduto;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "quantidade")
    private int quantidade;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "preco")
    private BigDecimal preco;

    @JsonIgnore
    @Column(name = "id_carrinho")
    private UUID idCarrinho;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrinho", referencedColumnName = "id", insertable = false, updatable = false)
    private Carrinho carrinho;
}
