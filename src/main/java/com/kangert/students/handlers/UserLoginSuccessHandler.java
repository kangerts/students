/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-26 20:46:14
 * @LastEditTime: 2021-06-24 10:46:09
 * @Description: 用户登录成功处理工具类
 */
package com.kangert.students.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kangert.students.utils.JwtUtil;
import com.kangert.students.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cn.hutool.json.JSONUtil;

@Configuration
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    ResponseUtil responseUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        // 生成JWT放入请求头中
        String jwt = jwtUtil.getJwtToken(authentication.getName());
        response.setHeader(jwtUtil.getHeader(), jwt);
        // 响应
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(JSONUtil.toJsonStr(responseUtil.ok("登录成功！")).getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
