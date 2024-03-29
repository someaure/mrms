package com.cqie.graduation.mrms.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqie.graduation.mrms.user.entity.Role;

/**
 * <p>
 * 系统角色 服务类
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
public interface IRoleService extends IService<Role> {

    /**
     * 创建角色
     *
     * @param role 角色
     * @return 创建的角色
     */
    Role createRole(Role role);

    /**
     * 删除角色
     *
     * @param roleId 角色编号
     */
    void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间关系
     *
     * @param roleId        角色编号
     * @param permissionIds 权限编号
     */
    void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     *
     * @param roleId        角色编号
     * @param permissionIds 权限编号
     */
    void unCorrelationPermissions(Long roleId, Long... permissionIds);
}
