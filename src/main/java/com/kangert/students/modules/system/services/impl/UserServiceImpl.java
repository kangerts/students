/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:51:16
 * @LastEditTime: 2021-06-24 10:48:57
 * @Description: 用户接口实现类
 */
package com.kangert.students.modules.system.services.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.kangert.students.modules.system.entitys.UserEntity;
import com.kangert.students.modules.system.repositorys.UserRepository;
import com.kangert.students.modules.system.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser() {
        String[] a = new String[5];
        for (int i = 0; i <= a.length; i++) {
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
    public String deleteAllUser() {
        userRepository.deleteAll();
        return "删除成功！";
    }

    @Override
    public Page<UserEntity> getUsers(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(Sort.Direction.ASC, "id"));
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