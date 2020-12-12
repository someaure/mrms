package com.cqie.graduation.mrms.base.exception;

/**
 * @author xd
 */
public interface ICustomErrorCode {
    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();

    /**
     * 获取错误状态码
     *
     * @return 状态码
     */
    Integer getCode();
}
