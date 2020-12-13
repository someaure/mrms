package com.cqie.graduation.mrms.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqie.graduation.mrms.user.entity.User;

import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xd
 * @since 2020-11-10
 */
public interface IUserService extends IService<User> {

    /**
     * 创建账户
     *
     * @param user 用户
     * @return 创建的用户
     */
    User createUser(User user);

    /**
     * 修改密码
     *
     * @param userId      用户编号
     * @param newPassword 新密码
     */
    void changePassword(Integer userId, String newPassword);

    /**
     * 添加用户-角色关系
     *
     * @param userId  用户编号
     * @param roleIds 角色编号
     */
    void correlationRoles(Integer userId, Long... roleIds);

    /**
     * 移除用户-角色关系
     *
     * @param userId  用户编号
     * @param roleIds 角色编号
     */
    void unCorrelationRoles(Integer userId, Long... roleIds);

    /**
     * 查找用户
     *
     * @param userId 用户编号
     * @return 用户
     */
    User findByUserId(Integer userId);

    /**
     * 查找用户
     *
     * @param userId 用户编号
     * @return 用户角色
     */
    Set<String> findRoles(Integer userId);

    /**
     * 根据用户编号查找其权限
     *
     * @param userId 用户名
     * @return 用户权限
     */
    Set<String> findPermissions(Integer userId);


    /**
     * 验证用户登录账号密码
     *
     * @param userId   用户账号
     * @param password 用户密码
     * @return 是否合法
     */
    boolean checkPassword(Integer userId, String password);

    /**
     * 用户登录
     *
     * @param userId     用户账号
     * @param password   用户密码
     * @param rememberMe 是否永久登录
     * @return 用户token
     */
    String login(Integer userId, String password, boolean rememberMe);
}
