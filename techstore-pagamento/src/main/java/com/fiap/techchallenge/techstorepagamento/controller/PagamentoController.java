package com.fiap.techchallenge.techstorepagamento.controller;

import com.fiap.techchallenge.techstorepagamento.dto.CarrinhoDTO;
import com.fiap.techchallenge.techstorepagamento.feign.CarrinhoFeignClient;
import com.fiap.techchallenge.techstorepagamento.service.PagamentoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;
    private final CarrinhoFeignClient carrinhoFeignClient;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService, CarrinhoFeignClient carrinhoFeignClient) {
        this.pagamentoService = pagamentoService;
        this.carrinhoFeignClient = carrinhoFeignClient;
    }

    @GetMapping("/simular/{idPedido}")
    public ResponseEntity<CarrinhoDTO> simularPagamento(@PathVariable UUID idPedido, HttpServletRequest request) {
        Map<String, String> headersMap = extrairHeaders(request);
        CarrinhoDTO carrinhoDTO = carrinhoFeignClient.obterItemPorId(headersMap, idPedido);
        carrinhoDTO = pagamentoService.simularPagamento(carrinhoDTO);
        return ResponseEntity.ok(carrinhoDTO);
    }

    @PostMapping("/processar/{idPedido}")
    public ResponseEntity<CarrinhoDTO> processarPagamento(@PathVariable UUID idPedido, HttpServletRequest request) {
        Map<String, String> headersMap = extrairHeaders(request);
        CarrinhoDTO carrinhoDTO = carrinhoFeignClient.obterItemPorId(headersMap, idPedido);
        pagamentoService.processarPagamento(idPedido, carrinhoDTO);
        Boolean atualizou = carrinhoFeignClient.pagamentoCarrinhoPorId(headersMap, idPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoDTO);
    }

    private Map<String, String> extrairHeaders(HttpServletRequest request) {
        Map<String, String> headersMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            List<String> headerValues = Collections.list(request.getHeaders(headerName));
            String headerValue = String.join(",", headerValues);
            headersMap.put(headerName, headerValue);
        }
        return headersMap;
    }
}
