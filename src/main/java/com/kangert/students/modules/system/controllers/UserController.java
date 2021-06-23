/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:53:42
 * @LastEditTime: 2021-06-23 17:02:02
 * @Description: 用户控制器接口
 */
package com.kangert.students.modules.system.controllers;

import com.kangert.students.modules.system.entitys.UserEntity;
import com.kangert.students.modules.system.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/add")
    public String addUser() {
        userService.addUser();
        return "成功";
    }

    @GetMapping(value = "/list")
    public Page<UserEntity> getUsers(@RequestParam int page, @RequestParam int pageSize) {
        return userService.getUsers(page, pageSize);
    }

    @PostMapping(value = "/del/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "删除ID：" + id + "成功！";
    }

    @DeleteMapping(value = "/del/all")
    public String deleteAllUser() {
        return userService.deleteAllUser();
    }

    @PutMapping(value = "/{id}/{username}")
    public String updateUser(@PathVariable("id") Long id, @PathVariable("username") String username) {
        return userService.updateUserName(id, username);
    }
}
