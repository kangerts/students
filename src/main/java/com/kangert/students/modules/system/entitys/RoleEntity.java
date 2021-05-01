/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 19:48:13
 * @LastEditTime: 2021-04-30 13:37:26
 * @Description: 角色实体类
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kangert.students.common.entitys.BaseEntity;
import com.kangert.students.common.enums.DataScopeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sys_role")
@JsonIgnoreProperties({ "roles" })
public class RoleEntity extends BaseEntity {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @ManyToMany(mappedBy = "roles")
    // @ApiModelProperty(value = "用户", hidden = true)
    private Set<UserEntity> users;

    @ManyToMany
    @JoinTable(name = "sys_roles_menus", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "role_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id") })
    // @ApiModelProperty(value = "菜单", hidden = true)
    private Set<MenuEntity> menus;

    // @NotBlank
    // @ApiModelProperty(value = "名称", hidden = true)
    private String name;

    // @ApiModelProperty(value = "数据权限，全部 、 本级 、 自定义")
    private String dataScope = DataScopeEnum.THIS_LEVEL.getValue();

    @Column(name = "level")
    // @ApiModelProperty(value = "级别，数值越小，级别越大")
    private Integer level = 3;

    // @ApiModelProperty(value = "描述")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleEntity role = (RoleEntity) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
