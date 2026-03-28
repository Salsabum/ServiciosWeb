package com.trabajo.auth_service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final String SECRET = "clave123clave123clave123clave123";

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {

        if(user.get("username").equals("admin") && user.get("password").equals("1234")) {

            SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

            String token = Jwts.builder()
                    .setSubject(user.get("username"))
                    .signWith(key, io.jsonwebtoken.SignatureAlgorithm.HS256)
                    .compact();

            return Map.of("token", token);
        }

        throw new RuntimeException("Credenciales incorrectas");
    }
}