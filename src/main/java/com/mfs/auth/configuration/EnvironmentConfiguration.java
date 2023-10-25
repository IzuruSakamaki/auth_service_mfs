package com.mfs.auth.configuration;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EnvironmentConfiguration {
    @Value("${jwt.secret}")
    private String jwt_secret;

    @Value("${jwt.lifetime}")
    private int jwt_lifetime;
}
