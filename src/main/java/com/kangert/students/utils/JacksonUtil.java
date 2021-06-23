/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-05-12 17:50:13
 * @LastEditTime: 2021-06-11 13:16:21
 * @Description: 对象序列化和反序列化
 */
package com.kangert.students.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public final class JacksonUtil {
    /**
     * ObjectMapper提供用于读取和写入JSON的功能
     */
    public final static ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS);
    }

    /**
     * 序列化
     * 
     * @param obj 对象
     * @return 序列化后的json字符串
     */
    public static String serialize(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     * 
     * @param <T>       泛型 转为那个对象
     * @param jsonText  json字符串
     * @param beanClass 目标对象
     * @return 转为目标对象
     */
    public static <T> T deserialize(String jsonText, Class<T> beanClass) {
        try {
            return OBJECT_MAPPER.readValue(jsonText, beanClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
