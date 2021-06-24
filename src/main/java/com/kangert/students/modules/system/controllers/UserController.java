/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:53:42
 * @LastEditTime: 2021-06-24 18:27:55
 * @Description: 用户控制器接口
 */
package com.kangert.students.modules.system.controllers;

import com.kangert.students.modules.system.entitys.UserEntity;
import com.kangert.students.modules.system.services.UserService;
import com.kangert.students.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户添加")
    @GetMapping(value = "/add")
    public ResponseUtil addUser() {
        return userService.addUser();
    }

    @ApiOperation(value = "用户列表")
    @ApiImplicitParams(value = { @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "当前页数据量", required = true) })
    @GetMapping(value = "/list")
    public ResponseUtil getUsers(@RequestParam int page, @RequestParam int pageSize) {
        return userService.getUsers(page, pageSize);
    }

    @ApiOperation(value = "用户删除")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    @DeleteMapping(value = "/del/{id}")
    public ResponseUtil deleteUser(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }

    @ApiOperation(value = "用户删除（所有）")
    @DeleteMapping(value = "/del/all")
    public ResponseUtil deleteAllUser() {
        return userService.deleteAllUser();
    }

    @ApiOperation(value = "用户更新")
    @PutMapping(value = "/update")
    public ResponseUtil updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }
}
