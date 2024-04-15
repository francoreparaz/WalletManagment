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

    public Key secretKey;
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

    public String createToken(Long userID) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + this.validityInMilliseconds);
        System.out.println(this.secretKey);
        return Jwts.builder()
                .claim("userId", userID)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(this.secretKey, SignatureAlgorithm.HS512)
                .compact();
    }
}
