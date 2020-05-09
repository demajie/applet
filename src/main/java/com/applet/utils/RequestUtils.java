package com.applet.utils;

import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author LuckyCurve
 * @date 2020/5/6 14:15
 */
@Component
public class RequestUtils {

    static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        RequestUtils.userService = userService;
    }

    public static HttpSession getHttpSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        return attributes.getRequest().getSession();
    }

    /**
     * 获取当前用户id
     */
    public static Integer getCurrentUserId() {
        HttpSession session = getHttpSession();
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            throw new KnownException(ExceptionEnum.NOT_LOGIN);
        }
        return (Integer) userId;
    }

    /**
     * 获取当前用户社区id
     */
    public static Integer getCurrentCommunityId() {
        Integer userId = getCurrentUserId();
        return userService.getById(userId).getCommunityId();
    }

    /**
     * 获取当前用户权限
     */
    public static Integer getCurrentPermId() {
        Integer userId = getCurrentUserId();
        return userService.getById(userId).getPermId();
    }
}
