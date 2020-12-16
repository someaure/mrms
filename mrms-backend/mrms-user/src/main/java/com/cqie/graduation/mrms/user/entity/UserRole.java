package com.cqie.graduation.mrms.user.entity;

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
    * 用户角色关联表
    */
@Data
@NoArgsConstructor
public class UserRole {
    private Integer userId;

    private Integer roleId;
}