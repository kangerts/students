/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:50:19
 * @LastEditTime: 2021-05-15 20:07:43
 * @Description: 用户服务接口
 */

package com.kangert.students.modules.system.services;

import com.kangert.students.modules.system.entitys.UserEntity;

import org.springframework.data.domain.Page;

public interface UserService {
    /**
     * 添加用户
     * 
     * @return 操作信息
     */
    String addUser();

    /**
     * 获取用户数据（分页）
     * 
     * @param page     当前页
     * @param pageSize 每页大小
     * @return 分页后的用户数据
     */
    Page<UserEntity> getUsers(int page, int pageSize);

    /**
     * 通过ID删除用户
     * 
     * @param id 用户ID
     * @return 操作信息
     */
    String deleteById(Long id);

    /**
     * 更新用户
     * 
     * @param oldName  旧用户名
     * @param username 新用户名
     * @return 操作信息
     */
    String updateUser(String oldName, String username);

    /**
     * 删除所有用户
     * 
     * @return 操作信息
     */
    String deleteAllUser();
}
