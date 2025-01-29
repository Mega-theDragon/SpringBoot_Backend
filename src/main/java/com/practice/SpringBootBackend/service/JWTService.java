package com.practice.SpringBootBackend.service;

import java.util.Date;
import java.util.HashMap;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.practice.SpringBootBackend.model.JWTDataHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JWTService {

    private final SecretKey secretKey;

    public String generateJWT(String subject){
        return Jwts.builder()
                .claims()
                .add(new HashMap<>())
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .and()
                .signWith(secretKey)
                .compact();
    }

    public JWTDataHolder generateJwtDataHolder(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return new JWTDataHolder(claims);
    }

    public boolean validateJWT(UserDetails userDetails, JWTDataHolder dataHolder){
        return userDetails.getUsername().equals(dataHolder.extractUsername()) 
                && dataHolder.extractExpirationDate().after(new Date(System.currentTimeMillis()));
    }

}
