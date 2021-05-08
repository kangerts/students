/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:47:37
 * @LastEditTime: 2021-05-08 14:53:55
 * @Description: 用户数据仓库
 */
package com.kangert.students.modules.system.repositorys;

import java.util.List;

import com.kangert.students.modules.system.entitys.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    List<UserEntity> findByUsername(String username);
}
