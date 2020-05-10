package com.applet.utils;

import com.applet.bean.entity.Unit;
import com.applet.bean.entity.User;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.service.BuildingService;
import com.applet.service.UnitService;
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
    static BuildingService buildingService;
    static UnitService unitService;

    @Autowired
    public void setUserService(UserService userService,BuildingService buildingService,UnitService unitService) {
        RequestUtils.userService = userService;
        RequestUtils.buildingService = buildingService;
        RequestUtils.unitService = unitService;
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

    /**
     * 获取当前住址，如B区9单元502室
     */
    public static String getCurrentAddress() {
        Integer userId = getCurrentUserId();
        User user = userService.getById(userId);
        return buildingService.getById(user.getBuildingId()).getName() +
                "区" + unitService.getById(user.getUnitId()).getName() +
                "单元" + user.getHouseNum() + "室";
    }
}
