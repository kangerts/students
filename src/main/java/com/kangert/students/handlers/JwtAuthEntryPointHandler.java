/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 18:21:36
 * @LastEditTime: 2021-04-30 16:46:23
 * @Description: JWT验证入口处理类（未认证）
 */
package com.kangert.students.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未认证：" + authException.getMessage());
    }
}
