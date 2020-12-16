package com.cqie.graduation.mrms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqie.graduation.mrms.user.entity.Menu;
import com.cqie.graduation.mrms.user.mapper.MenuMapper;
import com.cqie.graduation.mrms.user.mapper.RoleMenuMapper;
import com.cqie.graduation.mrms.user.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    private final RoleMenuMapper roleMenuMapper;

    @Override
    public List<Menu> findMenu(Set<Integer> roles) {
        Set<Integer> menuIds = roleMenuMapper.queryMenuIdByRoleIdIn(roles);
        menuIds.add(1);
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>(Menu.class);
        wrapper.in(Menu::getId, menuIds);
        return baseMapper.selectList(wrapper);
    }
}
