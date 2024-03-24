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

    private final AuthenticationFilter filter;

    public GatewayConfig(AuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/itens/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8083"))

                .route(r -> r.path("/api/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri(techstoreAuthUrl))
                .build();
    }

}

