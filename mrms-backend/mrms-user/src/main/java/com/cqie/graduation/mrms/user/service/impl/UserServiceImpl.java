package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.user.entity.User;
import com.cqie.graduation.mrms.user.mapper.UserMapper;
import com.cqie.graduation.mrms.user.service.IUserService;
import com.cqie.graduation.mrms.user.util.PasswordHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xd
 * @since 2020-11-10
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User createUser(User user) {
        //加密密码
        PasswordHelper.encryptPassword(user);
        return user;
    }

    @Override
    public void changePassword(Integer userId, String newPassword) {

    }

    @Override
    public void correlationRoles(Integer userId, Long... roleIds) {

    }

    @Override
    public void unCorrelationRoles(Integer userId, Long... roleIds) {

    }

    @Override
    public User findByUserId(Integer userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Set<String> findRoles(Integer userId) {
        return new HashSet<>();
    }

    @Override
    public Set<String> findPermissions(Integer userId) {
        return new HashSet<>();
    }

    @Override
    public boolean checkPassword(Integer userId, String password) {
        return false;
    }

    @Override
    public String login(Integer userId, String password) {

        return null;
    }
}
