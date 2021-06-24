/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:50:19
 * @LastEditTime: 2021-06-24 18:22:29
 * @Description: 用户服务接口
 */

package com.kangert.students.modules.system.services;

import com.kangert.students.modules.system.entitys.UserEntity;
import com.kangert.students.utils.ResponseUtil;

public interface UserService {
    /**
     * 添加用户
     * 
     * @return 操作信息
     */
    ResponseUtil addUser();

    /**
     * 获取用户数据（分页）
     * 
     * @param page     当前页
     * @param pageSize 每页大小
     * @return 分页后的用户数据
     */
    ResponseUtil getUsers(int page, int pageSize);

    /**
     * 通过ID删除用户
     * 
     * @param id 用户ID
     * @return 操作信息
     */
    ResponseUtil deleteById(Long id);

    /**
     * 删除所有用户
     * 
     * @return 操作信息
     */
    ResponseUtil deleteAllUser();

    /**
     * 更新用户信息
     * 
     * @param userEntity 用户数据
     * @return 返回更改信息
     */
    ResponseUtil updateUser(UserEntity userEntity);
}
