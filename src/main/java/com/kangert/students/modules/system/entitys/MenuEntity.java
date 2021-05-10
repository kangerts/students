/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 20:13:13
 * @LastEditTime: 2021-04-30 13:37:49
 * @Description: 菜单实体类
 */
package com.kangert.students.modules.system.entitys;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.kangert.students.common.entitys.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sys_menu")
public class MenuEntity extends BaseEntity {
    @Id
    @Column(name = "menu_id")
    // @NotNull(groups = { Update.class })
    // @ApiModelProperty(value = "ID", hidden = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @JSONField(serialize = false)
    @ManyToMany(mappedBy = "menus")
    // @ApiModelProperty(value = "菜单角色")
    private Set<RoleEntity> roles;

    // @ApiModelProperty(value = "菜单标题")
    private String title;

    @Column(name = "componentName")
    // @ApiModelProperty(value = "菜单组件名称")
    private String componentName;

    // @ApiModelProperty(value = "排序")
    private Integer menuSort = 999;

    // @ApiModelProperty(value = "组件路径")
    private String component;

    // @ApiModelProperty(value = "路由地址")
    private String path;

    // @ApiModelProperty(value = "菜单类型，目录、菜单、按钮")
    private Integer type;

    // @ApiModelProperty(value = "权限标识")
    private String permission;

    // @ApiModelProperty(value = "菜单图标")
    private String icon;

    @Column(columnDefinition = "bit(1) default 0")
    // @ApiModelProperty(value = "缓存")
    private Boolean cache;

    @Column(columnDefinition = "bit(1) default 0")
    // @ApiModelProperty(value = "是否隐藏")
    private Boolean hidden;

    // @ApiModelProperty(value = "上级菜单")
    private Long pid;

    // @ApiModelProperty(value = "子节点数目", hidden = true)
    private Integer subCount = 0;

    // @ApiModelProperty(value = "外链菜单")
    private Boolean iFrame;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuEntity menu = (MenuEntity) o;
        return Objects.equals(id, menu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
