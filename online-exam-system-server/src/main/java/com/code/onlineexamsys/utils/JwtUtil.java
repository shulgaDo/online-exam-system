package com.code.onlineexamsys.utils;

import com.code.onlineexamsys.common.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private SecretKey  secretKey;

    /**
     * 生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(secretKey)
                .compact();
    }

    /**
     * 生成token
     * @param account
     * @return
     */
    public String generateToken(String account){
        Map<String,Object> claims = new HashMap<>();
        claims.put("account",account);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .setSubject(account)
                .signWith(secretKey)
                .compact();
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public Claims extractClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * token中获取用户名
     * @param token
     * @return
     */
    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }

    /**
     * 解析token是否失效
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token,UserDetails userDetails){
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * 获取token过期时间
     * @param token
     * @return
     */
    public  Date extractExpiration(String token){
        return extractClaims(token).getExpiration();
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * 获取token
     * @param token
     * @return
     */
    public String resolveToken(String token){
        if(token != null && !token.startsWith(jwtProperties.getPrefix())){
            return token.substring(jwtProperties.getPrefix().length()).trim();
        }
        return null;
    }
}
