/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-26 21:07:40
 * @LastEditTime: 2021-06-25 11:27:47
 * @Description: JWT工具类
 */
package com.kangert.students.utils;

import java.nio.charset.Charset;
import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.AlgorithmUtil;
import cn.hutool.jwt.signers.JWTSignerUtil;

@Configuration
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

        return JWT.create().setHeader("type", "JWT").setCharset(Charset.forName("UTF-8")).setSubject(userName)
                .setIssuedAt(currentTime).setExpiresAt(expireTime).setSigner(JWTSignerUtil.hs512(secret.getBytes()))
                .sign();
    }

    /**
     * JWT是否合法
     * 
     * @param jwt JWT字符串
     * @return 是否合法（是否过期，是否非法签名）
     */
    public boolean isTokenLegal(String jwt) {
        boolean isItLegal = true;
        try {
            JWTValidator.of(jwt).validateAlgorithm(JWTSignerUtil.hs512(secret.getBytes()))
                    .validateDate(new Date(DateUtil.current()));
        } catch (Exception e) {
            isItLegal = false;
        }
        return isItLegal;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(long expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
