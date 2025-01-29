package com.practice.SpringBootBackend.model;

import java.util.Date;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JWTDataHolder {
    
    private Claims claims;

    public String extractUsername(){
        return claims.getSubject();
    }

    public Date extractExpirationDate(){
        return claims.getExpiration();
    }

}
