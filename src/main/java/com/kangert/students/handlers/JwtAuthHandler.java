/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 15:15:54
 * @LastEditTime: 2021-04-27 17:58:09
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
        // 获取jwt
        String jwt = request.getHeader(jwtUtil.getHeader());
        // 判断jwt为空还是未定义
        if (StrUtil.isBlankOrUndefined(jwt)) {
            chain.doFilter(request, response);
            return;
        }
        Claims claims = jwtUtil.getClaimsByToken(jwt);
        // 不存在
        if (claims == null) {
            throw new JwtException("Token异常！");
        }

        // jwt过期
        if (jwtUtil.isTokenExpire(claims)) {
            throw new JwtException("Token已过期");
        }

        String username = claims.getSubject();
        // 此时可以进行用户权限判断
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, null);
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }
}
