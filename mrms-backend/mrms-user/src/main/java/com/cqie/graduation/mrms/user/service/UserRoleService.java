package com.cqie.graduation.mrms.user.service;

import com.cqie.graduation.mrms.user.entity.UserRole;
    /**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface UserRoleService{


    int deleteByPrimaryKey(Integer userId,Integer roleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

}
