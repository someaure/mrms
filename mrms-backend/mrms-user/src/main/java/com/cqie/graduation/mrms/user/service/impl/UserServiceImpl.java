package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.base.exception.CustomErrorCode;
import com.cqie.graduation.mrms.base.exception.CustomException;
import com.cqie.graduation.mrms.user.entity.User;
import com.cqie.graduation.mrms.user.mapper.UserMapper;
import com.cqie.graduation.mrms.user.service.IUserService;
import com.cqie.graduation.mrms.user.util.PasswordHelper;
import com.cqie.graduation.mrms.user.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cqie.graduation.mrms.base.util.CommonStatic.TOKEN;

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
    @Value("${max-alive-time}")
    private int maxAliveTime;

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
        return baseMapper.selectById(userId);
    }

    @Override
    public Set<String> findRoles(Integer userId) {
        return new HashSet<>();
    }

    @Override
    public Set<String> findPermissions(Set<String> roles) {
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
            throw new CustomException(CustomErrorCode.AUTH_ERROR);
        }
        if (user.getLocked()) {
            throw new CustomException(CustomErrorCode.ACCOUNT_WAS_LOCKED);
        }

        String token = AuthUtil.sign(String.valueOf(userId), encryptPassword);

        if (rememberMe) {
            redisTemplate.opsForValue().set(TOKEN + userId, user);
        } else {
            redisTemplate.opsForValue().set(TOKEN + userId, user, maxAliveTime, TimeUnit.MINUTES);
        }
        return token;
    }
}
