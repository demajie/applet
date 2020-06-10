package com.applet.utils;

import com.applet.bean.entity.User;
import com.applet.bean.vo.CommentSimpleInfo;

import java.time.Year;

/**
 *  留言板工具类
 */
public class CommentUtils {
    /**
     * 获得留言类型
     */
    public static String getType(Integer typeId){
        if (typeId==null){
            return null;
        }
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

    /**
     *  获取查询的时间范围
     */
    public static Integer getTimeRange(Integer timeRangeId){
        if (timeRangeId==null){
            return null;
        }
        switch (timeRangeId){
            case 1:
                return 7;
            case 2:
                return 30;
            case 3:
                return 180;
            case 4:
                return 360;
        }
        return -1;
    }

    /**
     *  得到人物姓氏+[先生]|[女士]
     */
    public static String getFirstName(User user){
        String name = user.getName();
        String gender = user.getGender();
        if (gender.equals("男")){
            return name.substring(0,1) + "先生";
        }else if (gender.equals("女")){
            return name.substring(0,1) + "女士";
        }
        return "匿名居民";
    }

    /**
     *  管理员是否有权限办理
     */
    public static Integer hasPriorityToDeal(CommentSimpleInfo info) {
        if (info.getStatus()==0 || info.getAdminId()==RequestUtils.getCurrentUserId()) {
            return 1;
        }
        return 0;
    }
}
