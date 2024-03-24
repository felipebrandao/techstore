package com.fiap.techchallenge.techstorepagamento.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarrinhoDTO {

    private UUID id;
    private String username;
    private String status;
    private List<ItemCarrinhoDTO> itens = new ArrayList<>();
    private BigDecimal valorTotal;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate dataPagamento;
}
