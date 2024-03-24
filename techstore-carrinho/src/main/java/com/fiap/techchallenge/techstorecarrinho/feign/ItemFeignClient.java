package com.fiap.techchallenge.techstorecarrinho.feign;

import com.fiap.techchallenge.techstorecarrinho.feign.dto.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;
import java.util.UUID;

@FeignClient(name = "techstore-itens", url = "${techstore-gateway.url}")
public interface ItemFeignClient {


    @GetMapping("/api/itens/{id}")
    ItemDTO obterItemPorId(@RequestHeader Map<String, String> headerMap, @PathVariable UUID id);
}
