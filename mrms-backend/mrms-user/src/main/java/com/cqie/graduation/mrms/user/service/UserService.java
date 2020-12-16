package com.cqie.graduation.mrms.user.service;

import com.cqie.graduation.mrms.user.entity.User;

import java.util.Set;

/**
 * @author xd
 * @date 2020/12/16
 */
public interface UserService {
    boolean checkPassword(Integer userId, String password);

     String login(Integer userId, String password, boolean rememberMe);

    User createUser(User user);

    void changePassword(Integer userId, String newPassword);

    void correlationRoles(Integer userId, Long... roleIds);

    void unCorrelationRoles(Integer userId, Long... roleIds);

    User findByUserId(Integer userId);

     Set<String> findRoles(Integer userId);

     Set<String> findPermissions(Integer userId);
}
