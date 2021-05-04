/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:53:42
 * @LastEditTime: 2021-04-30 16:24:56
 * @Description: 用户控制器接口
 */
package com.kangert.students.modules.system.controllers;

import java.util.List;

import com.kangert.students.modules.system.entitys.UserEntity;
import com.kangert.students.modules.system.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/addUser")
    public String addUser() {
        userService.addUser();
        return "成功";
    }

    @GetMapping(value = "/getUsers")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "删除ID：" + id + "成功！";
    }
}