package com.cqie.graduation.mrms.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqie.graduation.mrms.user.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    /**
     * 查询菜单角色所拥有菜单
     *
     * @param roleIds 角色编号
     * @return 菜单编号
     */
    Set<Integer> queryMenuIdByRoleIdIn(@Param("roleIds") Set<Integer> roleIds);
}
