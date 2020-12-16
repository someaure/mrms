package com.cqie.graduation.mrms.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xd
 * @date 2020/12/16
 */
@Data
@NoArgsConstructor
public class Menu {
    private Integer id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 上级菜单
     */
    private Integer parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 资源地址
     */
    private String url;

    private Date gmtCreate;

    private Date gmtModify;
}