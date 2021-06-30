/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:51:16
 * @LastEditTime: 2021-06-30 13:44:36
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
import com.kangert.students.utils.ResponseUtil;

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

    @Autowired
    ResponseUtil responseUtil;

    @Override
    public ResponseUtil addUser() {
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
        return responseUtil.ok("添加成功！");
    }

    @Override
    public ResponseUtil deleteById(Long id) {
        userRepository.deleteById(id);
        return responseUtil.ok("删除成功：" + id);
    }

    @Override
    public ResponseUtil deleteAllUser() {
        userRepository.deleteAll();
        return responseUtil.ok("删除成功！");
    }

    @Override
    public ResponseUtil getUsers(int currentPage, int pageSize) {
        int page = currentPage > 0 ? currentPage - 1 : 0;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<UserEntity> userList = userRepository.findAll(new Specification<UserEntity>() {

            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {
                // TODO Auto-generated method stub
                return null;
            }
        }, pageable);
        return responseUtil.ok("获取用户成功！", userList);
    }

    @Override
    public ResponseUtil updateUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return responseUtil.ok("用户数据更改成功！");
    }
}