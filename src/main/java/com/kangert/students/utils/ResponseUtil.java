/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 18:10:19
 * @LastEditTime: 2021-04-27 14:11:37
 * @Description: 
 */
/*
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 18:10:19
 * @LastEditTime: 2021-04-25 18:45:41
 * @Description: 统一数据响应工具类
 */
package com.kangert.students.utils;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUtil implements Serializable {
    /**
     * 响应代码
     */
    private int code = -1;

    /**
     * 响应信息
     */
    private String message = "";

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 成功响应
     * 
     * @param data 响应的数据
     * @return 响应对象
     */
    public static ResponseUtil ok(String message) {
        ResponseUtil res = new ResponseUtil();
        res.setCode(200);
        res.setMessage("".equals(message) ? "操作成功！" : message);
        res.setData(null);
        return res;
    }

    /**
     * 成功响应
     * 
     * @param message 响应的信息
     * @param data    响应的数据
     * @return 响应对象
     */
    public static ResponseUtil ok(String message, Object data) {
        ResponseUtil res = new ResponseUtil();
        res.setCode(200);
        res.setMessage("".equals(message) ? "操作成功！" : message);
        res.setData(data);
        return res;
    }

    /**
     * 失败响应
     * 
     * @param message 响应的信息
     * @return 响应对象
     */
    public static ResponseUtil no(String message) {
        ResponseUtil res = new ResponseUtil();
        res.setCode(-1);
        res.setMessage("".equals(message) ? "操作失败！" : message);
        res.setData(null);
        return res;
    }
}