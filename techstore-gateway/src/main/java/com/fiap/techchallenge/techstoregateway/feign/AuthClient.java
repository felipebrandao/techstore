package com.fiap.techchallenge.techstoregateway.feign;

import com.fiap.techchallenge.techstoregateway.dto.UserTech;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "techstore-auth", url = "${techstore-auth.url}")
public interface AuthClient {

    @GetMapping("/api/auth/validate-token")

    UserTech validateToken(@RequestHeader Map<String, String> headerMap);
    //UserTech validateToken(@RequestHeader("Authorization") String token);
}
