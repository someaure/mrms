package com.cqie.graduation.mrms.user.mapper;

import com.cqie.graduation.mrms.base.mapper.MyMapper;
import com.cqie.graduation.mrms.user.entity.Dept;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface DeptMapper extends MyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}