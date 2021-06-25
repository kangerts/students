/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 15:15:54
 * @LastEditTime: 2021-06-25 11:00:17
 * @Description: JWT验证处理工具类
 */
package com.kangert.students.handlers;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kangert.students.utils.JacksonUtil;
import com.kangert.students.utils.JwtUtil;
import com.kangert.students.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import cn.hutool.core.util.StrUtil;

public class JwtAuthHandler extends BasicAuthenticationFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ResponseUtil responseUtil;

    public JwtAuthHandler(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        /**
         * 获取jwt
         */
        String jwt = request.getHeader(jwtUtil.getHeader());

        /**
         * 判断jwt为空还是未定义
         */
        if (StrUtil.isBlankOrUndefined(jwt)) {
            chain.doFilter(request, response);
            return;
        }

        /**
         * 判断jwt是否合法
         */
        if (!jwtUtil.isTokenLegal(jwt)) {
            response.getOutputStream().write(JacksonUtil.serialize(responseUtil.no("Token验证失败，请重新登录！")).getBytes());
            return;
        }

        String username = "";
        // 此时可以进行用户权限判断
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, null);
        SecurityContextHolder.getContext().setAuthentication(token);
        // SecurityContextHolder.getContext().getAuthentication()可以获取用户相关上下文信息（包含权限等信息）
        System.out.println("当前用户名称：" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        chain.doFilter(request, response);
    }
}
