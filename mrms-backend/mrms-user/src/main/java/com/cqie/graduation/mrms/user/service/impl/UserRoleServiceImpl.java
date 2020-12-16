package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.user.entity.UserRole;
import com.cqie.graduation.mrms.user.mapper.UserRoleMapper;
import com.cqie.graduation.mrms.user.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
