package com.applet.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 已知的异常枚举
 */

@AllArgsConstructor
@Getter
public enum ExceptionEnum {
    /**
     *  异常码 > 0 为 内部异常
     *  异常码 < 0 为 外部异常,应有调用者处理
     */
    TO_BE_IMPLEMENTED(55,"该功能待实现"),
    FILE_IO_EXCEPTION(58,"IO异常"),
    DATE_CONVERT_ERROR(66,"日期转换异常"),
    UNKNOWN_EXCEPTION(90,"服务器未知异常"),
    NOT_LOGIN(-1, "用户未登录"),
    NOT_AUTHENTICATE(-2,"用户未认证"),
    NO_PERMISSION(-3, "用户权限不够"),
    ERROR_IMAGE_FORMAT(-4,"图片格式不对")
    ;
    private int errorCode;
    private String errorMsg;
}
