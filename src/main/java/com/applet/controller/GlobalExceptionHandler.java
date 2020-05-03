package com.applet.controller;

import com.applet.common.JsonWrapper;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 *  @author : gsj
 *  全局异常处理
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  处理未知异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public JsonWrapper<String> handleUnKnownException(Exception e, HttpServletRequest request) {
        Integer errorCode = ExceptionEnum.UNKNOWN_EXCEPTION.getErrorCode();
        String errorMsg = ExceptionEnum.UNKNOWN_EXCEPTION.getErrorMsg();
        return new JsonWrapper<>(errorCode, errorMsg);
    }

    /**
     *  处理已知异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(KnownException.class)
    public JsonWrapper<String> handleKnownException(KnownException e, HttpServletRequest request) {
        Integer errorCode = e.getErrorCode();
        String errorMsg = e.getMessage();
        return new JsonWrapper<>(errorCode,errorMsg);
    }

}
