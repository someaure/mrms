package com.cqie.graduation.mrms.user.service.impl;

import com.cqie.graduation.mrms.user.service.UserRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.cqie.graduation.mrms.user.mapper.UserRoleMapper;
import com.cqie.graduation.mrms.user.entity.UserRole;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId,Integer roleId) {
        return userRoleMapper.deleteByPrimaryKey(userId,roleId);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

}
