package com.applet.service.impl;

import com.applet.bean.dto.SuperAdminAddInfo;
import com.applet.bean.dto.UserAddInfo;
import com.applet.bean.entity.User;
import com.applet.bean.vo.LoginInfo;
import com.applet.mapper.UserMapper;
import com.applet.service.UserService;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author LuckyCurve
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
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
        RequestUtils.getHttpSession().setAttribute("userId",userId);
        return LoginInfo.builder().isLogin(1).level(level).build();
    }

    @Override
    public Boolean saveUser(UserAddInfo userAddInfo) {
        User user = User.builder().id(userAddInfo.getAppId())
                .birthday(userAddInfo.getBirthday())
                .email(userAddInfo.getEmail())
                .buildingId(userAddInfo.getBuildingId())
                .gender(userAddInfo.getGender())
                .communityId(userAddInfo.getCommunityId())
                .name(userAddInfo.getName())
                .houseNum(userAddInfo.getHouseNum())
                .unitId(userAddInfo.getUnitId())
                .permId(0).build();
        RequestUtils.getHttpSession().setAttribute("userId",userAddInfo.getAppId());
        return save(user);
    }

    @Override
    public Boolean saveSuperAdminInfo(SuperAdminAddInfo info) {
        User user = User.builder().id(info.getId())
                .permId(2)
                .name(info.getName())
                .gender(info.getGender())
                .email(info.getEmail())
                .birthday(info.getBirthday()).build();
        RequestUtils.getHttpSession().setAttribute("userId",info.getId());
        return save(user);
    }
}
