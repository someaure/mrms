package com.cqie.graduation.mrms.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 锁定状态
     */
    private Boolean locked;

    /**
     * 绑定带你花
     */
    private String phone;

    /**
     * 绑定邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Boolean sex;

    private Date gmtCreate;

    private Date gmtUpdate;
}