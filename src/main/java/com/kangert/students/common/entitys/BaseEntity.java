/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 19:26:28
 * @LastEditTime: 2021-04-30 10:00:05
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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @CreatedBy
    @Column(name = "create_by", updatable = false)
    // @ApiModelProperty(value = "创建人", hidden = true)
    private String createBy;

    @LastModifiedBy
    @Column(name = "update_by")
    // @ApiModelProperty(value = "更新人", hidden = true)
    private String updateBy;

    @CreationTimestamp
    @Column(name = "create_time", updatable = false)
    // @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    // @ApiModelProperty(value = "更新时间", hidden = true)
    private Timestamp updateTime;

    // 删除状态（0：正常，1：删除）
    private int deleted = 0;
}