package com.mfs.auth.configuration;

import com.mfs.auth.entity.access.AccessRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfiguration {
    public String encryptToken(AccessRequest accessRequest, int range) {
        return Jwts.builder()
            .setSubject(accessRequest.getCode())
            .claim("credential", accessRequest.getPassword())
            .claim("time", System.currentTimeMillis() + range)
            .signWith(Keys.hmacShaKeyFor(ConstantConfiguration.AUTH_SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
            .compact();
    }

    public Claims decryptToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(ConstantConfiguration.AUTH_SECRET_KEY.getBytes()))
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
}
