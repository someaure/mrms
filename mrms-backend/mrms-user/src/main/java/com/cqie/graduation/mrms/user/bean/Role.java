package com.cqie.graduation.mrms.user.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author xd
 */
@Data
@EqualsAndHashCode
public class Role {
    private int id;
    private String roleName;
    private Set<Permission> permissions;
}
