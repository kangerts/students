/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-08-04 13:04:32
 * @LastEditTime: 2021-08-04 15:40:18
 * @Description: 
 */
package com.kangert.students.modules.test.services.impl;

import java.util.HashMap;
import java.util.Map;

import com.kangert.students.modules.test.services.TestService;

import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {

    @Override
    public Map<String, Object> userLogin(Map<String, Object> data) {

        System.out.println(data);

        String username = (String) data.get("username");

        Map<String, Object> res = new HashMap<String, Object>(16);

        res.put("body", data);
        res.put("code", 200);
        res.put("message", String.format("用户 %s 登录成功！", username));
        res.put("token", "This is Token");

          if ("admin".equals(username)) {
            String[] roles = {"admin"};
            String[] permissions = {"but", "view.add"};

            res.put("roles", roles);
            res.put("permissions", permissions);
        }
        
        if ("super".equals(username)) {
            String[] roles = {"super"};
            String[] permissions = {"but", "view"};

            res.put("roles", roles);
            res.put("permissions", permissions);
        }

        return res;
    }

    @Override
    public Map<String, Object> get(Map<String, Object> data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> post(Map<String, Object> data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> text(Map<String, Object> data) {
        // TODO Auto-generated method stub
        return null;
    }

}
