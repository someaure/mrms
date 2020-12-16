package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.user.entity.UserDept;
import com.cqie.graduation.mrms.user.mapper.UserDeptMapper;
import com.cqie.graduation.mrms.user.service.IUserDeptService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户部门关联表 服务实现类
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
@Service
public class UserDeptServiceImpl extends ServiceImpl<UserDeptMapper, UserDept> implements IUserDeptService {

}
