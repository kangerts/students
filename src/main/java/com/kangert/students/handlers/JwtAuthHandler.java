/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 15:15:54
 * @LastEditTime: 2021-05-13 11:10:32
 * @Description: JWT验证处理工具类
 */
package com.kangert.students.handlers;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kangert.students.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

public class JwtAuthHandler extends BasicAuthenticationFilter {

    @Autowired
    JwtUtil jwtUtil;

    public JwtAuthHandler(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        /**
         * 获取jwt，Claims
         */
        String jwt = request.getHeader(jwtUtil.getHeader());
        Claims claims = jwtUtil.getClaimsByToken(jwt);

        /**
         * 判断jwt为空还是未定义
         */
        if (StrUtil.isBlankOrUndefined(jwt)) {
            chain.doFilter(request, response);
            return;
        }

        /**
         * 不存在
         */
        if (claims == null) {
            throw new JwtException("Token异常！");
        }

        /**
         * jwt过期
         */
        if (jwtUtil.isTokenExpire(claims)) {
            throw new JwtException("Token已过期");
        }

        String username = claims.getSubject();
        // 此时可以进行用户权限判断
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, null);
        SecurityContextHolder.getContext().setAuthentication(token);
        // SecurityContextHolder.getContext().getAuthentication()可以获取用户相关上下文信息（包含权限等信息）
        System.out.println("当前用户名称：" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        chain.doFilter(request, response);
    }
}
