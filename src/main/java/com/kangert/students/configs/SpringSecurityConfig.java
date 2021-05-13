/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 15:51:39
 * @LastEditTime: 2021-05-13 10:49:35
 * @Description: SpringSecurity配置类
 */
package com.kangert.students.configs;

import com.kangert.students.handlers.JwtAccessDeniedHandler;
import com.kangert.students.handlers.JwtAuthEntryPointHandler;
import com.kangert.students.handlers.JwtAuthHandler;
import com.kangert.students.handlers.UserLoginFailureHandler;
import com.kangert.students.handlers.UserLoginSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 登录失败处理工具类
     */
    @Autowired
    private UserLoginFailureHandler userLoginFailureHandler;

    /**
     * 登录成功处理工具类
     */
    @Autowired
    private UserLoginSuccessHandler userLoginSuccessHandler;

    /**
     * JWT处理工具入口
     */
    @Autowired
    private JwtAuthEntryPointHandler jwtAuthEntryPointHandler;

    /**
     * JWT访问拒绝处理类
     */
    @Autowired
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    /**
     * JWT验证处理工具
     * 
     * @return Jwt验证处理类对象
     * @throws Exception 异常
     */
    @Bean
    protected JwtAuthHandler jwtAuthHandler() throws Exception {
        return new JwtAuthHandler(authenticationManager());
    }

    /**
     * 白名单
     */
    @Autowired
    private UrlWhiteListConfig urlWhiteListConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                // 登录配置
                .formLogin().successHandler(userLoginSuccessHandler).failureHandler(userLoginFailureHandler).and()
                // 禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                // 配置拦截规则
                .authorizeRequests().antMatchers(urlWhiteListConfig.getUrlWhiteListConfig()).permitAll().anyRequest()
                .authenticated()

                // 异常处理
                .and().exceptionHandling().authenticationEntryPoint(jwtAuthEntryPointHandler)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // 配置自定义过滤器
                .and().addFilter(jwtAuthHandler());
    }
}
