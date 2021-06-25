/** 
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 14:40:58
 * @LastEditTime: 2021-06-25 14:37:38
 * @Description: 用户尸体类
 */

package com.kangert.students.modules.system.entitys;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kangert.students.common.entitys.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "sys_user")
@SQLDelete(sql = "update sys_user set deleted = 1 where user_id = ?")
@Where(clause = "deleted = 0")
public class UserEntity extends BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户ID")
    @JsonProperty("Uid")
    public Long id;

    @ManyToMany
    @ApiModelProperty(value = "用户角色")
    @JoinTable(name = "sys_users_roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
    public Set<RoleEntity> roles;

    @NotBlank
    @Column(unique = true)
    @ApiModelProperty(value = "用户名称")
    @JsonProperty("Uname")
    public String username;

    @NotBlank
    @ApiModelProperty(value = "用户昵称")
    @JsonProperty("UnickName")
    public String nickName;

    @Email
    @NotBlank
    @ApiModelProperty(value = "邮箱")
    public String email;

    @NotBlank
    @ApiModelProperty(value = "电话号码")
    public String phone;

    @ApiModelProperty(value = "用户性别")
    public String gender;

    @ApiModelProperty(value = "头像真实名称", hidden = true)
    public String avatarName;

    @ApiModelProperty(value = "头像存储的路径", hidden = true)
    public String avatarPath;

    @ApiModelProperty(value = "密码")
    public String password;

    @NotNull
    @ApiModelProperty(value = "是否启用")
    public Boolean enabled;

    @ApiModelProperty(value = "是否为admin账号", hidden = true)
    public Boolean isAdmin = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity user = (UserEntity) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
