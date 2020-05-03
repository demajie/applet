package com.applet.common;

import com.applet.enums.ExceptionEnum;
import lombok.Getter;

/**
 *  自定义的异常
 */
@Getter
public class KnownException extends RuntimeException {
    /**
     *  异常码
     */
    private Integer errorCode;

    public KnownException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getErrorMsg());
        this.errorCode = exceptionEnum.getErrorCode();
    }
}
