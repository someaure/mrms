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
import java.util.Set;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author xd
 * @since 2020-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 锁定状态
     */
    @TableField("locked")
    private Boolean locked;

    /**
     * 绑定电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 绑定邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 性别
     */
    @TableField("sex")
    private Boolean sex;

    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    @TableField("gmt_update")
    private LocalDateTime gmtUpdate;

    @TableField(exist = false)
    private Set<String> roles;
}
