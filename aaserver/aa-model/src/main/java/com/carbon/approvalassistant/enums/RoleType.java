package com.carbon.approvalassistant.enums;

import lombok.Getter;

/**
 * @Author carbon
 * @Date 2021-01-24 22:56
 */
@Getter
public enum  RoleType {
    USER("USER", "用户"),
    TEMP_USER("TEMP_USER", "临时用户"),
    MANAGER("MANAGER", "管理者"),
    ADMIN("ADMIN", "Admin");
    private final String name;
    private final String description;

    RoleType(java.lang.String name, java.lang.String description) {
        this.name = name;
        this.description = description;
    }
}
