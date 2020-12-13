package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.base.exception.CustomErrorCode;
import com.cqie.graduation.mrms.base.exception.CustomException;
import com.cqie.graduation.mrms.base.util.CommonStatic;
import com.cqie.graduation.mrms.user.entity.User;
import com.cqie.graduation.mrms.user.mapper.UserMapper;
import com.cqie.graduation.mrms.user.service.IUserService;
import com.cqie.graduation.mrms.user.util.PasswordHelper;
import com.cqie.graduation.mrms.user.util.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xd
 * @since 2020-11-10
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private final RedisTemplate<Object, Object> redisTemplate;

    @Override
    public User createUser(User user) {
        //加密密码
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
    public String login(Integer userId, String password, boolean rememberMe) {
        User user = baseMapper.selectById(userId);
        if (user == null) {
            throw new CustomException(CustomErrorCode.NO_ACCOUNT);
        }
        String encryptPassword = PasswordHelper.encryptPassword(password);
        if (!encryptPassword.equals(user.getPassword())) {
            log.info(encryptPassword);
            log.info(user.getPassword());
            throw new CustomException(CustomErrorCode.AUTH_ERROR);
        }
        if (user.isLocked()) {
            throw new CustomException(CustomErrorCode.ACCOUNT_WAS_LOCKED);
        }

        String token = AuthUtil.sign(String.valueOf(userId), password);
        if (rememberMe) {
            redisTemplate.opsForValue().set(CommonStatic.TOKEN + token, user);
        } else {
            redisTemplate.opsForValue().set(CommonStatic.TOKEN + token, user, 30, TimeUnit.MINUTES);
        }
        return token;
    }
}