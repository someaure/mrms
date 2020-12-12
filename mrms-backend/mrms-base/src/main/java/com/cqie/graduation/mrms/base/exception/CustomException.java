package com.cqie.graduation.mrms.base.exception;

/**
 * @author xd
 */
public class CustomException extends RuntimeException {
    private final String message;
    private final Integer code;


    public CustomException(CustomErrorCode customErrorCode) {
        this.message = customErrorCode.getMessage();
        this.code = customErrorCode.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
