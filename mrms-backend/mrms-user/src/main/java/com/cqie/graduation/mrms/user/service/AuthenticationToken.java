package com.cqie.graduation.mrms.user.service;

import java.io.Serializable;

public interface AuthenticationToken extends Serializable {
    /**
     * 获取身份
     *
     * @return 身份
     */
    Object getPrincipal();

    /**
     * 获取凭据
     *
     * @return 凭据
     */
    Object getCredentials();
}
