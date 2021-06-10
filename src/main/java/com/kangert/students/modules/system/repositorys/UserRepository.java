/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:47:37
 * @LastEditTime: 2021-06-10 10:32:54
 * @Description: 用户数据仓库
 */
package com.kangert.students.modules.system.repositorys;

import java.util.List;

import com.kangert.students.modules.system.entitys.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    /**
     * 通过用户名称查找用户实体
     * 
     * @param username 用户名称
     * @return 返回用户实体
     */
    List<UserEntity> findByUsername(String username);

}
