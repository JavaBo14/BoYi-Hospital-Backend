package com.boyi.hospital.utils;


import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JWTUtil {
    
    
    /**
    * token 过期时间，7天
    */
    private static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;
    
    /**
    * 加密的秘钥
    */
    private static final String SECRET = "aR8#hV9d!Wz2$k5JpR5fFf7Yr2XzTg6iLq9uT#P+uVYk5C";
    
    /**
    * 令牌前缀
    */
    private static final String TOKEN_PREFIX = "boer";
    
    /**
    * subject
    */
    private static final String SUBJECT = "bobo";
    
    
    /**
    * 根据用户信息，生成令牌
    * @return
    */
    public static String geneJsonWebToken(User user) {
        
        if (user == null) {
            throw  new BusinessException(ErrorCode.PARAMS_ERROR,"请求参数为空");
        }
        
        String token = Jwts.builder().setSubject(SUBJECT)
                //payload
                .claim("user_nick", user.getUserNick())
                .claim("user_id", user.getUserId())
                .claim("account", user.getAccount())
                .claim("hospital_no", user.getHospitalNo())
                .claim("status", user.getStatus())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        
        token = TOKEN_PREFIX + token;
        return token;
    }
    
    
    /**
    * 校验token的方法
    *
    * @param token
    * @return
    */
    public static Claims checkJWT(String token) {
        
        try {
            
            final Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            
            return claims;
            
        } catch (Exception e) {
            log.info("JWT token解密失败");
            return null;
        }
        
    }
    
    
}

