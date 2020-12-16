package com.cqie.graduation.mrms.user.entity;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  *
  *
  *
  * @author xd
  * @date 2020/12/16
  */
/**
    * 系统角色
    */
@Data
@NoArgsConstructor
public class Role {
    private Integer id;

    /**
    * 角色名
    */
    private String name;

    /**
    * 描述
    */
    private String desc;

    private Date gmtCreate;

    private Date gmtUpdate;
}