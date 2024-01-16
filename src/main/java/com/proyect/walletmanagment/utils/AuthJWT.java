package com.proyect.walletmanagment.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;

@Component
public class AuthJWT {

    private Key secretKey;
    private final long validityInMilliseconds = 3600000; // 1 hora

    @PostConstruct
    public void init() {
        this.secretKey = generateSecretKey();
    }

    private Key generateSecretKey() {
        // Generar una clave secreta de 512 bits utilizando un algoritmo seguro
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[64];
        secureRandom.nextBytes(keyBytes);

        return new javax.crypto.spec.SecretKeySpec(keyBytes, SignatureAlgorithm.HS512.getJcaName());
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    public Key getSecret() {
        return this.secretKey;
    }
}
