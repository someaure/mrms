package com.cqie.graduation.mrms.user.mapper;

import com.cqie.graduation.mrms.base.mapper.MyMapper;
import com.cqie.graduation.mrms.user.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface RoleMenuMapper extends MyMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);
}