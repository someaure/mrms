package com.cqie.graduation.mrms.user.service.impl;

import com.cqie.graduation.mrms.user.service.UserDeptService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.cqie.graduation.mrms.user.mapper.UserDeptMapper;
import com.cqie.graduation.mrms.user.entity.UserDept;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
@Service
public class UserDeptServiceImpl implements UserDeptService {

    @Resource
    private UserDeptMapper userDeptMapper;

    @Override
    public int deleteByPrimaryKey(Integer id,Integer userId,Integer deptId) {
        return userDeptMapper.deleteByPrimaryKey(id,userId,deptId);
    }

    @Override
    public int insert(UserDept record) {
        return userDeptMapper.insert(record);
    }

    @Override
    public int insertSelective(UserDept record) {
        return userDeptMapper.insertSelective(record);
    }

}
