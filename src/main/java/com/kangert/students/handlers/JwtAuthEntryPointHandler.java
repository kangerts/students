/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 18:21:36
 * @LastEditTime: 2021-06-24 18:08:00
 * @Description: JWT验证入口处理类（未认证）
 */
package com.kangert.students.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kangert.students.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import cn.hutool.json.JSONUtil;

@Component
public class JwtAuthEntryPointHandler implements AuthenticationEntryPoint {

    @Autowired
    private ResponseUtil responseUtil;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(JSONUtil.toJsonStr(responseUtil.no("未认证：" + authException.getMessage())).getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
