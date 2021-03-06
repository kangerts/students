/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 19:26:28
 * @LastEditTime: 2021-05-14 17:09:39
 * @Description: 所有实体类的基类
 */
package com.kangert.students.common.entitys;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @CreatedBy
    @Column(name = "create_by", updatable = false)
    // @ApiModelProperty(value = "创建人", hidden = true)
    /**
     * 创建人
     */
    public String createBy;

    @LastModifiedBy
    @Column(name = "update_by")
    // @ApiModelProperty(value = "更新人", hidden = true)
    /**
     * 更新人
     */
    public String updateBy;

    @CreationTimestamp
    @Column(name = "create_time", updatable = false)
    // @ApiModelProperty(value = "创建时间", hidden = true)
    /**
     * 创建时间
     */
    public Timestamp createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    // @ApiModelProperty(value = "更新时间", hidden = true)
    /**
     * 更新时间
     */
    public Timestamp updateTime;

    /**
     * 删除状态（0：正常，1：删除）
     */
    public int deleted = 0;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

}