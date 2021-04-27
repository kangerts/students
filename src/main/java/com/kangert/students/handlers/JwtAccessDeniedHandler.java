/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 18:25:57
 * @LastEditTime: 2021-04-27 18:28:29
 * @Description: JWT访问拒绝处理类
 */
package com.kangert.students.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // TODO Auto-generated method stub

    }

}
