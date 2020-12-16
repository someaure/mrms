package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.user.entity.UserRole;
import com.cqie.graduation.mrms.user.mapper.UserRoleMapper;
import com.cqie.graduation.mrms.user.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xd
 * @date 2020/12/16
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

}
