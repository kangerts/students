/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-04-27 20:11:02
 * @LastEditTime: 2021-04-27 20:12:15
 * @Description:数据权限枚举
 */
package com.kangert.students.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataScopeEnum {

    /* 全部的数据权限 */
    ALL("全部", "全部的数据权限"),

    /* 自己部门的数据权限 */
    THIS_LEVEL("本级", "自己部门的数据权限"),

    /* 自定义的数据权限 */
    CUSTOMIZE("自定义", "自定义的数据权限");

    private final String value;
    private final String description;

    public static DataScopeEnum find(String val) {
        for (DataScopeEnum dataScopeEnum : DataScopeEnum.values()) {
            if (val.equals(dataScopeEnum.getValue())) {
                return dataScopeEnum;
            }
        }
        return null;
    }
}
