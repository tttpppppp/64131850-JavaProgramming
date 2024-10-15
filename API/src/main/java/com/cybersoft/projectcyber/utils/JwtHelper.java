package com.cybersoft.projectcyber.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import static io.jsonwebtoken.Jwts.*;

@Component
public class JwtHelper {
    @Value("${spring.jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = builder().subject(data).signWith(key).compact();
        return jws;
    }
    public boolean validateToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
