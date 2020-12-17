package com.cqie.graduation.mrms.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqie.graduation.mrms.user.entity.User;

import java.util.Set;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
public interface IUserService extends IService<User> {

    /**
     * 检查用户密码
     *
     * @param userId   用户编号
     * @param password 密码
     * @return 密码是否正确
     */
    boolean checkPassword(Integer userId, String password);

    /**
     * 用户登录
     *
     * @param userId     用户编号
     * @param password   用户密码
     * @param rememberMe 是否记住登录状态
     * @return 用户token
     */
    String login(Integer userId, String password, boolean rememberMe);

    /**
     * 创建用户
     *
     * @param user 用户实体
     * @return 创建的用户
     */
    User createUser(User user);

    /**
     * 修改用户密码
     *
     * @param userId      用户编号
     * @param newPassword 新密码
     */
    void changePassword(Integer userId, String newPassword);

    /**
     * 关联用户角色
     *
     * @param userId  用户编号
     * @param roleIds 角色编号
     */
    void correlationRoles(Integer userId, Long... roleIds);

    /**
     * 删除用户角色
     *
     * @param userId  用户编号
     * @param roleIds 角色编号
     */
    void unCorrelationRoles(Integer userId, Long... roleIds);

    /**
     * 通过Id 查找用户
     *
     * @param userId 用户编号
     * @return User
     */
    User findByUserId(Integer userId);

    /**
     * 查询用户角色信息
     *
     * @param userId 用户编号
     * @return 用户角色
     */
    Set<String> findRoles(Integer userId);

    /**
     * 获取角色权限
     *
     * @param roles 角色
     * @return 权限Set
     */
    Set<String> findPermissions(Set<String> roles);
}
