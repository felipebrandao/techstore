package com.fiap.techchallenge.techstoregateway.config;

import com.fiap.techchallenge.techstoregateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${techstore-auth.url}")
    private String techstoreAuthUrl;

    @Value("${techstore-carrinho.url}")
    private String techstoreCarrinhoUrl;

    @Value("${techstore-itens.url}")
    private String techstoreItensUrl;

    @Value("${techstore-pagamento.url}")
    private String techstorePagamentoUrl;
    private final AuthenticationFilter filter;

    public GatewayConfig(AuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/carrinho/**")
                        .filters(f -> f.filter(filter))
                        .uri(techstoreCarrinhoUrl))

                .route(r -> r.path("/api/itens/**")
                        .filters(f -> f.filter(filter))
                        .uri(techstoreItensUrl))

                .route(r -> r.path("/api/pagamentos/**")
                        .filters(f -> f.filter(filter))
                        .uri(techstorePagamentoUrl))

                .route(r -> r.path("/api/auth/**")
                        .uri(techstoreAuthUrl))
                .build();
    }

}

