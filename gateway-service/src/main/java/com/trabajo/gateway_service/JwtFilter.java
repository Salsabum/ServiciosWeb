//package com.trabajo.gateway_service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//import javax.crypto.SecretKey;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final String SECRET = "clave123clave123clave123clave123";
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain)
//            throws ServletException, IOException {
//
//        String header = request.getHeader("Authorization");
//
//        // 🔥 SI NO HAY TOKEN → RESPONDER BIEN
//        if (header == null || !header.startsWith("Bearer ")) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//            response.getWriter().write("{\"error\":\"Token requerido\"}");
//            return;
//        }
//
//        try {
//            String token = header.replace("Bearer ", "");
//
//            SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
//
//            Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
//
//        } catch (Exception e) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//            response.getWriter().write("{\"error\":\"Token inválido\"}");
//            return;
//        }
//
//        // ✅ TODO OK
//        chain.doFilter(request, response);
//    }
//}