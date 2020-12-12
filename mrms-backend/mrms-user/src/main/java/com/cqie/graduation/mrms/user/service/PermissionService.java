package com.cqie.graduation.mrms.user.service;

import com.cqie.graduation.mrms.user.bean.Permission;

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
}
