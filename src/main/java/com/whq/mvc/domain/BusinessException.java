package com.whq.mvc.domain;

/**
 * @Description: 业务异常类
 * @Author: whq
 * @Date: 2021/9/4 9:59
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
