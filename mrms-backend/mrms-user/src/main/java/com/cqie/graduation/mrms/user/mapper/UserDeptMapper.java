package com.cqie.graduation.mrms.user.mapper;

import com.cqie.graduation.mrms.base.mapper.MyMapper;
import com.cqie.graduation.mrms.user.entity.UserDept;
import org.apache.ibatis.annotations.Param;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface UserDeptMapper extends MyMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("userId") Integer userId, @Param("deptId") Integer deptId);

    int insert(UserDept record);

    int insertSelective(UserDept record);
}