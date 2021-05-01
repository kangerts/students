/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:51:16
 * @LastEditTime: 2021-04-30 15:46:03
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
            user.setPassword("password");
            user.setAvatarName("avatarName");
            user.setAvatarPath("avatarPath");
            user.setEmail("email@qq.com");
            user.setEnabled(true);
            user.setPhone("phone");
            user.setNickName("nickName");
            userRepository.save(user);
        }
        return "添加成功！";
    }

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> list = userRepository.findAll();
        System.out.println(list.size());
        return list;
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "删除成功！";
    }

}
