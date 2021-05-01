/** 
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 14:40:58
 * @LastEditTime: 2021-04-30 16:38:16
 * @Description: 用户尸体类
 */

package com.kangert.students.modules.system.entitys;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kangert.students.common.entitys.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sys_user")
@SQLDelete(sql = "update sys_user set deleted = 1 where user_id = ?") // 逻辑删除（不真实删除）
@Where(clause = "deleted = 0") // 过滤掉逻辑删除的
public class UserEntity extends BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @ApiModelProperty(value = "ID", hidden = true)
    @JsonProperty("Uid")
    private Long id;

    @ManyToMany(cascade = CascadeType.REMOVE)
    // @ApiModelProperty(value = "用户角色")
    @JoinTable(name = "sys_users_roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
    private Set<RoleEntity> roles;

    @NotBlank
    @Column(unique = true)
    // @ApiModelProperty(value = "用户名称")
    @JsonProperty("Uname")
    private String username;

    @NotBlank
    // @ApiModelProperty(value = "用户昵称")
    @JsonProperty("UnickName")
    private String nickName;

    @Email
    @NotBlank
    // @ApiModelProperty(value = "邮箱")
    private String email;

    @NotBlank
    // @ApiModelProperty(value = "电话号码")
    private String phone;

    // @ApiModelProperty(value = "用户性别")
    private String gender;

    // @ApiModelProperty(value = "头像真实名称", hidden = true)
    private String avatarName;

    // @ApiModelProperty(value = "头像存储的路径", hidden = true)
    private String avatarPath;

    // @ApiModelProperty(value = "密码")
    private String password;

    @NotNull
    // @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    // @ApiModelProperty(value = "是否为admin账号", hidden = true)
    private Boolean isAdmin = false;

    @Column(name = "pwd_reset_time")
    // @ApiModelProperty(value = "最后修改密码的时间", hidden = true)
    private Date pwdResetTime;

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
