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
public class Dept {
    private Integer id;

    private String name;

    private Integer parentId;

    private Date gmtCreate;

    private Date gmtUpdate;
}