/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-29 20:50:19
 * @LastEditTime: 2021-08-04 15:00:34
 * @Description: Test服务接口
 */

package com.kangert.students.modules.test.services;

import java.util.Map;

public interface TestService {
    /**
     * 用户登录接口
     * 
     * @param data request数据
     * @return response
     */
    Map<String, Object> userLogin(Map<String, Object> data);

    /**
     * GET
     * 
     * @param data request
     * @return response
     */
    Map<String, Object> get(Map<String, Object> data);

    /**
     * POST
     * 
     * @param data request
     * @return respone
     */
    Map<String, Object> post(Map<String, Object> data);

    /**
     * TEXT
     * 
     * @param data request
     * @return respone
     */
    Map<String, Object> text(Map<String, Object> data);

}
