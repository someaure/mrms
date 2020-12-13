package com.cqie.graduation.mrms.base.exception;

/**
 * @author xd
 */

public enum CustomErrorCode implements ICustomErrorCode {
    //系统错误
    SYS_ERROR(500, "系统错误"),
    //登录过期
    AUTH_EXPIRED(2000, "登录过期"),
    //账号不存在
    NO_ACCOUNT(1000, "账号不存在"),
    //密码错误
    AUTH_ERROR(1001, "密码输入错误"),
    //账户被锁定
    ACCOUNT_WAS_LOCKED(1002, "账号已被锁定"),
    //输入错误密码次数过多
    ERROR_LOGIN_TIMES_TOO_MUCH(1003, "输入错误密码次数过多");

    private final String message;
    private final Integer code;


    CustomErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
