package com.fiap.techchallenge.techstorepagamento.feign;

import com.fiap.techchallenge.techstorepagamento.dto.CarrinhoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;
import java.util.UUID;

@FeignClient(name = "techstore-carrinho", url = "${techstore-gateway.url}")
public interface CarrinhoFeignClient {

    @GetMapping("/api/carrinho/{id}")
    CarrinhoDTO obterItemPorId(@RequestHeader Map<String, String> headerMap, @PathVariable UUID id);

    @PutMapping("/api/carrinho/pagamento/{id}")
    Boolean pagamentoCarrinhoPorId(@RequestHeader Map<String, String> headerMap, @PathVariable UUID id);
}
