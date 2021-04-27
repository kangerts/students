/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 14:38:08
 * @LastEditTime: 2021-04-27 15:10:26
 * @Description: 项目启动入口
 */

package com.kangert.students;

import com.kangert.students.utils.ResponseUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }

    @GetMapping("/")
    public ResponseUtil hello() {
        int[] a = { 1, 2, 3 };
        return ResponseUtil.ok("", a);
    }
}
