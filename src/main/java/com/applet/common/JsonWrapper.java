package com.applet.common;

import lombok.Data;

/**
 *  统一返回的数据格式
 */


@Data
public class JsonWrapper<T> {

    private static final Integer SUCCESS_CODE = 0;
    private static final String SUCCESS_MSG = "success";


    /**
     *  状态返回码, 0 代表成功
     *  >0 服务器内部异常
     *  <0 外部异常,由调用者处理
     */
    private Integer code;

    /**
     *  api调用情况
     */
    private String msg;


    /**
     *  封装的数据
     */
    private T data;

    public JsonWrapper(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonWrapper(Integer code, String msg) {
        this(code,msg,null);
    }

    public JsonWrapper(T data) {
        this(SUCCESS_CODE,SUCCESS_MSG,data);
    }


}
