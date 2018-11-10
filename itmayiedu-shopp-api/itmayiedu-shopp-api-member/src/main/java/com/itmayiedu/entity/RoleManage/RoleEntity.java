package com.itmayiedu.entity.RoleManage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class RoleEntity {

    private String RoleAttributes; // 角色属性
    private String RoleDescribe;   // 角色描述
    private String RoleType;         // 角色描述
    private String RoleName;         // 角色名称
    private Integer RoleDisable; // 是否禁用角色:  1 是 0 否
    private Integer RoleLeve;     // 角色权限:  1000 超级管理员 0 普通护士 1 院长



}
