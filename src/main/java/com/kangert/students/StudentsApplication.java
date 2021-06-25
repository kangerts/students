/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 14:38:08
 * @LastEditTime: 2021-06-25 10:43:23
 * @Description: 项目启动入口
 */

package com.kangert.students;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.kangert.students.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.date.DateUtil;

@SpringBootApplication
@RestController
public class StudentsApplication {

    @Autowired
    ResponseUtil responseUtil;

    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }

    @GetMapping("/")
    public ResponseUtil serverInfo() {
        Map<String, Object> data = new HashMap<String, Object>(2);
        data.put("serverVersion", "v0.0.1");
        data.put("serverTime", DateUtil.now());
        return responseUtil.ok("服务端运行成功！", data);
    }

    @GetMapping("/DruidInfo")
    public ResponseUtil druidInfo() {
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外
        // DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return responseUtil.ok("", DruidStatManagerFacade.getInstance().getDataSourceStatDataList());
    }
}
