/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-30 10:18:05
 * @LastEditTime: 2021-04-30 10:41:30
 * @Description: 系统操作日志
 */
package com.kangert.students.modules.log.entitys;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sys_log")
@NoArgsConstructor
public class LogEntity implements Serializable {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 操作用户 */
    private String username;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    /** 参数 */
    private String params;

    /** 日志类型 */
    private String logType;

    /** 请求ip */
    private String requestIp;

    /** 地址 */
    private String address;

    /** 浏览器 */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细 */
    private byte[] exceptionDetail;

    /** 创建日期 */
    @CreationTimestamp
    private Timestamp createTime;

    public LogEntity(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
