/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-08-04 13:08:39
 * @LastEditTime: 2021-08-04 15:51:45
 * @Description: Test
 */
package com.kangert.students.modules.test.controllers;

import java.util.Map;

import com.kangert.students.modules.test.services.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mock")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping(value = "/login")
    public Map<String, Object> userLogin(@RequestBody Map<String, Object> data) {
        return testService.userLogin(data);
    }
}
