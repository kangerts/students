/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-05-13 09:53:12
 * @LastEditTime: 2021-05-13 10:44:40
 * @Description: Spring Security网址路径白名单
 */
package com.kangert.students.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlWhiteListConfig {
    protected static String[] urlWhiteListConfig;

    public String[] getUrlWhiteListConfig() {
        return UrlWhiteListConfig.urlWhiteListConfig;
    }

    @Value(value = "${students.web.urlWhiteListConfig}")
    public void setUrlWhiteListConfig(String urlWhiteListConfig) {
        // 切割字符串转为字符串数字
        UrlWhiteListConfig.urlWhiteListConfig = urlWhiteListConfig.split(",");
    }
}
