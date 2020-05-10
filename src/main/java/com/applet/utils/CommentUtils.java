package com.applet.utils;

/**
 *  留言板工具类
 */
public class CommentUtils {
    /**
     * 获得留言类型
     */
    public static String getType(Integer typeId){
        switch (typeId){
            case 1:
                return "饮食";
            case 2:
                return "环境";
            case 3:
                return "服务";
        }
        return "未知类型";
    }
}
