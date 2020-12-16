package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.user.entity.Dept;
import com.cqie.graduation.mrms.user.mapper.DeptMapper;
import com.cqie.graduation.mrms.user.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @author xd
 * @date 2020/12/16
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
