package com.whq.mvc.intercept;

import com.whq.mvc.domain.BusinessException;
import com.whq.mvc.domain.CommonErrorCode;
import com.whq.mvc.domain.ErrorCode;
import com.whq.mvc.domain.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局异常处理类
 * @Author: whq
 * @Date: 2021/9/4 10:24
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public RestResponse<Nullable> exceptionGet(HttpServletRequest request, HttpServletResponse response, Exception e) {
        if (e instanceof BusinessException) {
            BusinessException exception = (BusinessException) e;
            ErrorCode errorCode = exception.getErrorCode();
            if (CommonErrorCode.CUSTOM.equals(exception)) {
                return RestResponse.<Nullable>fail(errorCode.getCode(), e.getMessage());
            } else {
                return RestResponse.<Nullable>fail(errorCode.getCode(), errorCode.getDesc());
            }
        } else if (e instanceof NoHandlerFoundException) {
            return RestResponse.<Nullable>fail(HttpStatus.NOT_FOUND.value(), "找不到资源");
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return RestResponse.<Nullable>fail(HttpStatus.METHOD_NOT_ALLOWED.value(), "method 方法不支持");
        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            return RestResponse.<Nullable>fail(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "不支持媒体类型");
        }
        log.error("[系统异常]{}", e);
        return RestResponse.<Nullable>fail(CommonErrorCode.UNKNOWN.getCode(), CommonErrorCode.UNKNOWN.getDesc());
    }
}
