/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 14:38:08
 * @LastEditTime: 2021-05-11 14:15:09
 * @Description: 项目启动入口
 */

package com.kangert.students;

import java.util.HashMap;
import java.util.Map;

import com.kangert.students.utils.ResponseUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.date.DateUtil;

@SpringBootApplication
@RestController
public class StudentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }

    @GetMapping("/")
    public ResponseUtil serverInfo() {
        Map<String, Object> data = new HashMap<String, Object>(16);
        data.put("serverVersion", "v0.0.1");
        data.put("serverTime", DateUtil.now());
        return ResponseUtil.ok("服务端运行成功！", data);
    }

    // @GetMapping("/DruidInfo")
    // public ResponseUtil DruidInfo() {
    // // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外
    // // DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
    // return ResponseUtil.ok("",
    // DruidStatManagerFacade.getInstance().getDataSourceStatDataList());
    // }
}
