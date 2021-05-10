/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-26 21:07:40
 * @LastEditTime: 2021-04-27 18:08:06
 * @Description: JWT工具类
 */
package com.kangert.students.utils;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {

    /**
     * JWT秘钥
     */
    private String secret;

    /**
     * 过期时间（秒）
     */
    private long expireSeconds;

    /**
     * JWT头名称
     */
    private String header;

    /**
     * 生成JWT字符串
     * 
     * @param userName 用户名称
     * @return 返回JWT字符串
     */
    public String getJwtToken(String userName) {
        // 获取当前时间对象
        Date currentTime = new Date(DateUtil.current());

        // 计算过期时的时间
        Date expireTime = new Date(currentTime.getTime() + 1000 * expireSeconds);

        return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(userName).setIssuedAt(currentTime)
                .setExpiration(expireTime).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 解析JWT
     * 
     * @param jwt JWT字符串
     * @return Claims对象
     */
    public Claims getClaimsByToken(String jwt) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * JWT是否过期
     * 
     * @param claims JWT对象
     * @return 是否过期（布尔值）
     */
    public boolean isTokenExpire(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}
