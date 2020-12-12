package com.cqie.graduation.mrms.base.bean;

import com.cqie.graduation.mrms.base.exception.CustomErrorCode;
import com.cqie.graduation.mrms.base.exception.CustomException;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.http.HttpStatus;

/**
 * @author xd
 */
@Data
public class Response {
    private int status;
    private String msg;
    private Object data;

    public Response ok() {
        this.status = getHttpStatusCode(HttpStatus.OK);
        return this;
    }

    public Response error() {
        this.status = getHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return this;
    }

    public Response error(String message) {
        this.status = getHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        this.msg = message;
        return this;
    }

    public Response error(AuthenticationException exception) {
        this.status = HttpStatus.UNAUTHORIZED.value();
        this.msg = exception.getMessage();
        return this;
    }

    public Response error(CustomException customException) {
        this.status = customException.getCode();
        this.msg = customException.getMessage();
        return this;
    }

    public Response error(CustomErrorCode customErrorCode) {
        this.status = customErrorCode.getCode();
        this.msg = customErrorCode.getMessage();
        return this;
    }

    public Response msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Response data(Object data) {
        this.data = data;
        return this;
    }

    public int getHttpStatusCode(HttpStatus httpStatus) {
        return httpStatus.value();
    }
}
