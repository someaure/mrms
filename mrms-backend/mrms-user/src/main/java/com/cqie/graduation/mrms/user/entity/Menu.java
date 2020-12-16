package com.cqie.graduation.mrms.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名
     */
    @TableField("name")
    private String name;

    /**
     * 上级菜单
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 资源地址
     */
    @TableField("url")
    private String url;

    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    @TableField("gmt_modify")
    private LocalDateTime gmtModify;


}
