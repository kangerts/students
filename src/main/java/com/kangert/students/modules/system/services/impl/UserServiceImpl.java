/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:51:16
 * @LastEditTime: 2021-05-08 14:51:19
 * @Description: 用户接口实现类
 */
package com.kangert.students.modules.system.services.impl;

import java.util.List;

import com.kangert.students.modules.system.entitys.UserEntity;
import com.kangert.students.modules.system.repositorys.UserRepository;
import com.kangert.students.modules.system.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser() {
        for (int i = 0; i <= 5; i++) {
            UserEntity user = new UserEntity();
            user.setUsername("username" + i);
            user.setPassword("password" + i);
            user.setAvatarName("avatarName" + i);
            user.setAvatarPath("avatarPath" + i);
            user.setEmail("email@qq.com" + i);
            user.setEnabled(true);
            user.setPhone("phone" + i);
            user.setNickName("nickName" + i);
            userRepository.save(user);
        }
        return "添加成功！";
    }

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> list = userRepository.findAll();
        return list;
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "删除成功！";
    }

    @Override
    public String updateUser(String oldName, String username) {
        List<UserEntity> users = userRepository.findByUsername(oldName);
        if (users.size() > 0) {
            UserEntity user = users.get(0);
            user.setUsername(username);
            userRepository.save(user);
        }
        return "成功！";
    }
}