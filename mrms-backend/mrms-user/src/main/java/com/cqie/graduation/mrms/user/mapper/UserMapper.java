package com.cqie.graduation.mrms.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqie.graduation.mrms.user.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xd
 * @since 2020-11-10
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 用户登录
     *
     * @param userId   用户编号
     * @param password 用户密码
     * @return 用户信息
     */
    User userLogin(@Param("userId") Integer userId, @Param("password") String password);
}
