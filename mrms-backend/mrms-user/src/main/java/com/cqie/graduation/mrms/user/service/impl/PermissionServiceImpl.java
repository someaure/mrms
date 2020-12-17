package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.user.entity.Permission;
import com.cqie.graduation.mrms.user.mapper.PermissonMapper;
import com.cqie.graduation.mrms.user.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author xd
 * @date 2020/12/16
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissonMapper, Permission> implements IPermissionService {
    @Override
    public Permission createPermission(Permission permission) {
        return null;
    }

    @Override
    public void deletePermission(Long permissionId) {

    }

    @Override
    public Set<String> getPermission(Set<String> roles) {

        return null;
    }
}
