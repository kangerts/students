/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 20:13:13
 * @LastEditTime: 2021-05-14 17:05:22
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

@Entity
@Table(name = "sys_menu")
public class MenuEntity extends BaseEntity {
    @Id
    @Column(name = "menu_id")
    // @NotNull(groups = { Update.class })
    // @ApiModelProperty(value = "ID", hidden = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // @JSONField(serialize = false)
    @ManyToMany(mappedBy = "menus")
    // @ApiModelProperty(value = "菜单角色")
    public Set<RoleEntity> roles;

    // @ApiModelProperty(value = "菜单标题")
    public String title;

    @Column(name = "componentName")
    // @ApiModelProperty(value = "菜单组件名称")
    public String componentName;

    // @ApiModelProperty(value = "排序")
    public Integer menuSort = 999;

    // @ApiModelProperty(value = "组件路径")
    public String component;

    // @ApiModelProperty(value = "路由地址")
    public String path;

    // @ApiModelProperty(value = "菜单类型，目录、菜单、按钮")
    public Integer type;

    // @ApiModelProperty(value = "权限标识")
    public String permission;

    // @ApiModelProperty(value = "菜单图标")
    public String icon;

    @Column(columnDefinition = "bit(1) default 0")
    // @ApiModelProperty(value = "缓存")
    public Boolean cache;

    @Column(columnDefinition = "bit(1) default 0")
    // @ApiModelProperty(value = "是否隐藏")
    public Boolean hidden;

    // @ApiModelProperty(value = "上级菜单")
    public Long pid;

    // @ApiModelProperty(value = "子节点数目", hidden = true)
    public Integer subCount = 0;

    // @ApiModelProperty(value = "外链菜单")
    public Boolean iFrame;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSubCount() {
        return subCount;
    }

    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }

    public Boolean getiFrame() {
        return iFrame;
    }

    public void setiFrame(Boolean iFrame) {
        this.iFrame = iFrame;
    }

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
