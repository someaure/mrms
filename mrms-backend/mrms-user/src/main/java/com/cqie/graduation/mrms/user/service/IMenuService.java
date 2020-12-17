package com.cqie.graduation.mrms.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqie.graduation.mrms.user.entity.Menu;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 查询角色菜单
     *
     * @param roles 角色列表
     * @return 菜单
     */
    List<Menu> findMenu(Set<Integer> roles);
}
