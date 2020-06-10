package com.applet.service.impl;

import com.applet.bean.dto.SuperAdminAddInfo;
import com.applet.bean.dto.UserAddBaseInfo;
import com.applet.bean.dto.UserAddressInfo;
import com.applet.bean.entity.User;
import com.applet.bean.vo.LoginInfo;
import com.applet.bean.vo.UserBaseInfo;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.mapper.UserMapper;
import com.applet.service.CommunityService;
import com.applet.service.UserService;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.BeanProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LuckyCurve
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommunityService communityService;

    @Override
    public LoginInfo lsLogin(Integer userId) {
        User user = getById(userId);
        if (user == null) {
            return LoginInfo.builder().isLogin(0).build();
        }
        String level = "普通用户";
        if (user.getPermId() == 1) {
            level = "管理员";
        } else if (user.getPermId() == 2) {
            level = "超级管理员";
        }
        //存储用户id
        String sessionId = RequestUtils.getHttpSession().getId();
        RequestUtils.getHttpSession().setAttribute("userId", userId);
        return LoginInfo.builder().isLogin(1).level(level).jSessionId(sessionId).build();
    }

    @Override
    public Boolean saveUser(UserAddBaseInfo userAddInfo) {
        User user = new User();
        BeanUtils.copyProperties(userAddInfo, user);
        user.setId(userAddInfo.getAppId());
        user.setPermId(0);
        RequestUtils.getHttpSession().setAttribute("userId", userAddInfo.getAppId());
        return save(user);
    }

    @Override
    public Boolean saveSuperAdminInfo(SuperAdminAddInfo info) {
        User user1 = getById(info.getId());
        if (user1 != null) {
            throw new KnownException(ExceptionEnum.EXIST_USER);
        }
        User user = User.builder().id(info.getId())
                .permId(2)
                .name(info.getName())
                .gender(info.getGender())
                .email(info.getEmail())
                .birthday(info.getBirthday()).build();
        RequestUtils.getHttpSession().setAttribute("userId", info.getId());
        return save(user);
    }

    @Override
    public String getCurrentAddress() {
        return RequestUtils.getCurrentAddress();
    }

    @Override
    public Boolean saveAddressInfo(UserAddressInfo userAddressInfo) {
        Integer userId = RequestUtils.getCurrentUserId();
        User user = new User();
        BeanUtils.copyProperties(userAddressInfo, user);
        user.setId(userId);
        return updateById(user);
    }

    @Override
    public Integer countByHouse(String house) {
        return userMapper.countByHouse(house);
    }

    @Override
    public UserBaseInfo getBaseInfo() {
        Integer id = RequestUtils.getCurrentUserId();
        User user = getById(id);
        UserBaseInfo info = new UserBaseInfo();
        BeanUtils.copyProperties(user, info);
        //超级管理员
        if (user.getPermId() == 2) {
            String name = communityService.getById(user.getCommunityId()).getName();
            info.setAddress(name);
            return info;
        }
        info.setAddress(RequestUtils.getCurrentAddress());
        return info;
    }
}
