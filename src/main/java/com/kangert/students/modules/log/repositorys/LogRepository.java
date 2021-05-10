/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-30 10:21:08
 * @LastEditTime: 2021-04-30 10:22:06
 * @Description: 日志数据仓库
 */
package com.kangert.students.modules.log.repositorys;

import com.kangert.students.modules.log.entitys.LogEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long>, JpaSpecificationExecutor<LogEntity> {

    /**
     * 根据日志类型删除信息
     * 
     * @param logType 日志类型
     */
    @Modifying
    @Query(value = "delete from sys_log where log_type = ?1", nativeQuery = true)
    void deleteByLogType(String logType);
}
