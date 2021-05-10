/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:50:19
 * @LastEditTime: 2021-05-08 14:49:58
 * @Description: 用户服务接口
 */

package com.kangert.students.modules.system.services;

import java.util.List;

import com.kangert.students.modules.system.entitys.UserEntity;

public interface UserService {
    String addUser();

    List<UserEntity> getUsers();

    String deleteById(Long id);

    String updateUser(String oldName, String username);
}
