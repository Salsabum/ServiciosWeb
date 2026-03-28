package com.trabajo.gateway_service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    private final String SECRET = "clave123clave123clave123clave123";
    private RestTemplate rest = new RestTemplate();

    @GetMapping("/datos/{id}")
    public String datos(@RequestHeader(value = "Authorization", required = false) String header,
                        @PathVariable String id) {


        if (header == null || !header.startsWith("Bearer ")) {
            return "Error: Se requiere un token de autenticación.";
        }

        try {
            String token = header.replace("Bearer ", "");
            SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

        } catch (Exception e) {
            return "Error: Token inválido o no autorizado.";
        }

        
        switch (id) {
            case "1":
                return rest.getForObject("http://localhost:8082/datos", String.class);
            case "2":
                return rest.getForObject("http://localhost:8083/datos", String.class);
            case "3":
                return rest.getForObject("http://localhost:8084/datos", String.class);
            default:
                return "Error: Microservicio no encontrado.";
        }
    }
}