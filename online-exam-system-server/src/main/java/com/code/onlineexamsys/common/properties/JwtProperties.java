package com.code.onlineexamsys.common.properties;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.header}")
    private String header;

    @Value(("${jwt.prefix}"))
    private String prefix;

    @PostConstruct
    public void init(){
        if(secret.length() < 12){
            throw new IllegalArgumentException("JWT密匙长度必须至少32位");
        }
    }
}
