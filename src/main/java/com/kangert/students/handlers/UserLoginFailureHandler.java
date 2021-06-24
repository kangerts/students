/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-26 20:28:31
 * @LastEditTime: 2021-06-24 10:43:30
 * @Description: 用户登录失败处理工具类
 */
package com.kangert.students.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kangert.students.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import cn.hutool.json.JSONUtil;

@Configuration
public class UserLoginFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    ResponseUtil responseUtil;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();
        // 响应
        outputStream.write(JSONUtil.toJsonStr(responseUtil.no("登录失败：" + exception.getMessage())).getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }

}
