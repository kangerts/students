/*
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 14:40:58
 * @LastEditTime: 2021-04-25 15:05:19
 * @Description: 用户尸体类
 */

package com.kangert.students.modules.system.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "k_users")
public class UserEntity {

    /**
     * 用户ID （主键）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer uid;

    /**
     * 用户名称
     */
    public String username;

    /**
     * 用户密码
     */
    public String password;

    /**
     * 0 系统用户， 1 学校管理员， 2 教师， 3 学生
     */
    public int userType;
}
