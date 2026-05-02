package com.code.onlineexamsys.config.security;

import com.code.onlineexamsys.common.properties.JwtProperties;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Bean
    public SecretKey secretKey(JwtProperties jwtProperties){
       return Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
    }
}
