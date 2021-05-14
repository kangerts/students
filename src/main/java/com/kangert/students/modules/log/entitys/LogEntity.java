/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-30 10:18:05
 * @LastEditTime: 2021-05-14 17:06:38
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

@Entity
@Table(name = "sys_log")
public class LogEntity implements Serializable {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /** 操作用户 */
    public String username;

    /** 描述 */
    public String description;

    /** 方法名 */
    public String method;

    /** 参数 */
    public String params;

    /** 日志类型 */
    public String logType;

    /** 请求ip */
    public String requestIp;

    /** 地址 */
    public String address;

    /** 浏览器 */
    public String browser;

    /** 请求耗时 */
    public Long time;

    /** 异常详细 */
    public byte[] exceptionDetail;

    /** 创建日期 */
    @CreationTimestamp
    public Timestamp createTime;

    public LogEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public byte[] getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(byte[] exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public LogEntity(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
