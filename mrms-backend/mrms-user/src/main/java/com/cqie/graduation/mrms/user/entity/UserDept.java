package com.cqie.graduation.mrms.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xd
 * @date 2020/12/16
 */

/**
 * 用户部门关联表
 */
@Data
@NoArgsConstructor
public class UserDept {
    private Integer id;

    private Integer userId;

    private Integer deptId;
}