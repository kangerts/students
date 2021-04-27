/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 18:21:36
 * @LastEditTime: 2021-04-27 18:27:34
 * @Description: JWT验证入口处理类
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
        // TODO Auto-generated method stub

    }

}
