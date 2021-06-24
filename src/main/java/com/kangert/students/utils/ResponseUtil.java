/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 18:10:19
 * @LastEditTime: 2021-06-24 18:05:38
 * @Description: 统一数据响应工具类
 */
package com.kangert.students.utils;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.stereotype.Component;

@JsonPropertyOrder(value = { "code", "msg", "data" })
@Component
public class ResponseUtil implements Serializable {
    /**
     * 响应代码
     */
    public int code = -1;

    /**
     * 响应信息
     */
    public String msg = "";

    /**
     * 响应数据
     */
    public Object data = null;

    /**
     * 成功响应
     * 
     * @param data 响应的数据
     * @return
     * @return 响应对象
     */
    public ResponseUtil ok(String msg) {
        setCode(200);
        setMsg("".equals(msg) ? "操作成功！" : msg);
        setData(null);
        return this;
    }

    /**
     * 成功响应
     * 
     * @param message 响应的信息
     * @param data    响应的数据
     * @return 响应对象
     */
    public ResponseUtil ok(String msg, Object data) {
        setCode(200);
        setMsg("".equals(msg) ? "操作成功！" : msg);
        setData(data);
        return this;
    }

    /**
     * 失败响应
     * 
     * @param message 响应的信息
     * @return 响应对象
     */
    public ResponseUtil no(String msg) {
        setCode(-1);
        setMsg("".equals(msg) ? "操作失败！" : msg);
        setData(null);
        return this;
    }

    private void setCode(int code) {
        this.code = code;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    private void setData(Object data) {
        this.data = data;
    }
}
