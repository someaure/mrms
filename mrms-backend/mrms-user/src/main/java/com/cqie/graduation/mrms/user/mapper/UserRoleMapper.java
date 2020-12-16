package com.cqie.graduation.mrms.user.mapper;

import com.cqie.graduation.mrms.base.mapper.MyMapper;
import com.cqie.graduation.mrms.user.entity.UserRole;
import org.apache.ibatis.annotations.Param;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface UserRoleMapper extends MyMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);
}