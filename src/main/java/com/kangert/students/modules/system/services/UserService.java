/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:50:19
 * @LastEditTime: 2021-05-15 19:31:56
 * @Description: 用户服务接口
 */

package com.kangert.students.modules.system.services;

import com.kangert.students.modules.system.entitys.UserEntity;

import org.springframework.data.domain.Page;

public interface UserService {
    String addUser();

    Page<UserEntity> getUsers(int page, int pageSize);

    String deleteById(Long id);

    String updateUser(String oldName, String username);

    String deleteAllUser();
}
