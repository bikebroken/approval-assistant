package com.carbon.approvalassistant.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Date;

/**
 * @Author carbon
 * @Date 2020-12-13 12:02
 */
@Slf4j
public class JwtUtil {

    /**
     * 这个密钥是防止JWT被篡改的关键，随便写什么都好，但绝不能泄露
     */
    private final static String secretKey = "whatever";
    private final static Duration expiration = Duration.ofHours(2);

    /**
     * 生成JWT
     * @param userName 用户名
     * @return JWT
     */
    public static String generate(String userName) {
        Date expiryDate = new Date(System.currentTimeMillis() + expiration.toMillis());

        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public static Claims parse(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            log.error("parse token error." , e);
        }
        return claims;
    }
}
