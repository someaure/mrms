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
@Data
@NoArgsConstructor
public class Dept {
    private Integer id;

    private String name;

    private Integer parentId;

    private Date gmtCreate;

    private Date gmtUpdate;
}