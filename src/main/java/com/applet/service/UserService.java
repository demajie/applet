package com.applet.service;


import com.applet.bean.dto.UserAddInfo;
import com.applet.bean.entity.User;
import com.applet.bean.vo.LoginInfo;
import com.applet.bean.vo.MessageInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 判断用户是否是第一次登录，并返回权限信息
     */
    LoginInfo lsLogin();

    /**
     * 保存用户信息
     */
    Boolean saveUser(UserAddInfo userAddInfo);



}
