package com.mfs.auth.configuration;

import com.mfs.auth.entity.access.AccessRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class TokenConfiguration {
    @Autowired
    EnvironmentConfiguration environmentConfiguration;
    public String encryptToken(AccessRequest accessRequest) {
        return Jwts.builder()
            .setSubject(accessRequest.getCode())
            .setExpiration(new Date(System.currentTimeMillis() + environmentConfiguration.getJwt_lifetime()))
            .signWith(Keys.hmacShaKeyFor(environmentConfiguration.getJwt_secret().getBytes()), SignatureAlgorithm.HS256)
            .compact();
    }

    public Claims decryptToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(environmentConfiguration.getJwt_secret().getBytes()))
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
}
