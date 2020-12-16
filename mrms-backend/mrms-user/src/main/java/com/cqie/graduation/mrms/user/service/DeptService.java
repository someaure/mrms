package com.cqie.graduation.mrms.user.service;

import com.cqie.graduation.mrms.user.entity.Dept;
    /**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface DeptService{


    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

}
