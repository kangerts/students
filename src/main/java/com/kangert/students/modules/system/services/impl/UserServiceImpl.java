/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:51:16
 * @LastEditTime: 2021-05-14 13:33:41
 * @Description: 用户接口实现类
 */
package com.kangert.students.modules.system.services.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.kangert.students.modules.system.entitys.UserEntity;
import com.kangert.students.modules.system.repositorys.IUserRepository;
import com.kangert.students.modules.system.services.IUserService;
import com.kangert.students.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public String addUser() {
        for (int i = 0; i <= 100; i++) {
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

    @Override
    public String deleteAllUser() {
        userRepository.deleteAll();
        return "删除成功！";
    }

    @Override
    public Page<UserEntity> getUsers(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return userRepository.findAll(new Specification<UserEntity>() {

            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {
                // TODO Auto-generated method stub

                return null;
            }

        }, pageable);
    }
}