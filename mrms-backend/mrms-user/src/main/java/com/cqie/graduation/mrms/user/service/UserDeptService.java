package com.cqie.graduation.mrms.user.service;

import com.cqie.graduation.mrms.user.entity.UserDept;
    /**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface UserDeptService{


    int deleteByPrimaryKey(Integer id,Integer userId,Integer deptId);

    int insert(UserDept record);

    int insertSelective(UserDept record);

}
