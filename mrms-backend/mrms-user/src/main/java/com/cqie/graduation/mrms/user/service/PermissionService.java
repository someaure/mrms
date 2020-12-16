package com.cqie.graduation.mrms.user.service;

import com.cqie.graduation.mrms.user.bean.Permission;

import java.util.Set;

public interface PermissionService {
    /**
     * 创建权限
     *
     * @param permission 权限
     * @return 创建的权限
     */
    Permission createPermission(Permission permission);

    /**
     * 删除权限
     *
     * @param permissionId 权限编号
     */
    void deletePermission(Long permissionId);

    /**
     * 获取权限
     */
    Set<String> getPermission(Set<String> roles);
}
