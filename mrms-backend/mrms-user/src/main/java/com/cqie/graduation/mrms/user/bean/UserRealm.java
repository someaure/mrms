package com.cqie.graduation.mrms.user.bean;

import com.cqie.graduation.mrms.user.entity.User;
import com.cqie.graduation.mrms.user.util.util.AuthUtil;
import com.cqie.graduation.mrms.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author xd
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class UserRealm extends AuthorizingRealm {
    private final static String TOKEN = "token:";
    private final IUserService userService;
    private final RedisTemplate<Object, Object> redisTemplate;
    @Value("${max-alive-time}")
    private int maxAliveTime;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof BearerToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer userId = user.getId();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = userService.findRoles(userId);
        authorizationInfo.addStringPermissions(userService.findPermissions(userId));
        authorizationInfo.addRoles(roles);
        return authorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String tokenStr = ((BearerToken) token).getToken();
        String userId = AuthUtil.getUserId(tokenStr);
        String key = TOKEN + tokenStr;
        User user = (User) redisTemplate.opsForValue().get(TOKEN + tokenStr);
        if (user != null) {
            redisTemplate.expire(key, maxAliveTime, TimeUnit.MINUTES);
        } else {
            throw new AccountException("登录失效");
        }
        if (!AuthUtil.verify(tokenStr, userId, user.getPassword())) {
            throw new CredentialsException("账号验证失败");
        }
        if (Boolean.TRUE.equals(user.isLocked())) {
            //帐号锁定
            throw new LockedAccountException("账号:" + userId + "  已被锁定");
        }

        return new SimpleAuthenticationInfo(
                //用户名
                user,
                //密码
                tokenStr,
                //realm name
                getName()
        );
    }

    @Override
    protected void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }


}
