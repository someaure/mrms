package com.cqie.graduation.mrms.base.exception;

/**
 * @author xd
 */

public enum CustomErrorCode implements ICustomErrorCode {
    //输入错误密码次数过多
    ERROR_LOGIN_TIMES_TOO_MUCH(1000, "输入错误密码次数过多"),
    //系统错误
    SYS_ERROR(500, "系统错误"),
    //系统错误
    AUTH_ERROR(500, "系统错误"),
    //系统错误
    TOKEN_ERROR(1001, "token验证错误");

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
