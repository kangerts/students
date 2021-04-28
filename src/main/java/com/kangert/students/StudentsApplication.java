/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-25 14:38:08
 * @LastEditTime: 2021-04-28 13:28:48
 * @Description: 项目启动入口
 */

package com.kangert.students;

import com.alibaba.druid.stat.DruidStatManagerFacade;
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

    @GetMapping("/DruidInfo")
    public ResponseUtil hello() {
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外
        // DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return ResponseUtil.ok("", DruidStatManagerFacade.getInstance().getDataSourceStatDataList());
    }
}
