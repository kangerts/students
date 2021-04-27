/** 
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 18:55:15
 * @LastEditTime: 2021-04-27 14:09:49
 * @Description: 全局异常处理工具类
 */

package com.kangert.students.handlers;

import com.kangert.students.utils.ResponseUtil;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseUtil handler(AccessDeniedException e) {
        log.error("AccessDeniedException ---> 访问拒绝异常！");
        return ResponseUtil.no("访问拒绝异常！");
    }

    /**
     * 拦截全局运行时异常
     * 
     * @param e 捕获的异常
     * @return 响应数据
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseUtil handler(RuntimeException e) {
        log.error("RuntimeException ---> 运行时异常！");
        return ResponseUtil.no("运行时异常！");
    }

    /**
     * 拦截全局不合法的参数异常
     * 
     * @param e 捕获的异常
     * @return 响应数据
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseUtil handler(IllegalArgumentException e) {
        log.error("IllegalArgumentException ---> 不合法的参数异常！");
        return ResponseUtil.no("不合法的参数异常！");
    }

    /**
     * 拦截全局实体检验异常
     * 
     * @param e 捕获的异常
     * @return 响应数据
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseUtil handler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException ---> 实体校验异常！", e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return ResponseUtil.no(objectError.getDefaultMessage());
    }
}
