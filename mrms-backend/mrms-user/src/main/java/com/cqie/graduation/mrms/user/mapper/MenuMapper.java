package com.cqie.graduation.mrms.user.mapper;

import com.cqie.graduation.mrms.base.mapper.MyMapper;
import com.cqie.graduation.mrms.user.entity.Menu;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
public interface MenuMapper extends MyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}