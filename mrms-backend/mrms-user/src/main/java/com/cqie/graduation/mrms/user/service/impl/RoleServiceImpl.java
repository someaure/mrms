package com.cqie.graduation.mrms.user.service.impl;

import com.cqie.graduation.mrms.user.bean.Role;
import com.cqie.graduation.mrms.user.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author xd
 * @date 2020/12/16
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public Role createRole(Role role) {
        return null;
    }

    @Override
    public void deleteRole(Long roleId) {

    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public void unCorrelationPermissions(Long roleId, Long... permissionIds) {

    }
}
