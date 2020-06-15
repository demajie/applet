package com.applet.service;


import com.applet.bean.dto.SuperAdminAddInfo;
import com.applet.bean.dto.UserAddBaseInfo;
import com.applet.bean.dto.UserAddressInfo;
import com.applet.bean.entity.User;
import com.applet.bean.vo.LoginInfo;
import com.applet.bean.vo.MessageInfo;
import com.applet.bean.vo.UserBaseInfo;
import com.applet.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService extends IService<User> {

    /**
     * 判断用户是否是第一次登录，并返回权限信息，存储用户id
     */
    LoginInfo lsLogin(Integer userId);

    /**
     * 保存用户信息
     */
    Boolean saveUser(UserAddBaseInfo userAddBaseInfo);


    /**
     * 超级管理员信息登记
     */
    Boolean saveSuperAdminInfo(SuperAdminAddInfo info);

    String getCurrentAddress();

    Boolean saveAddressInfo(UserAddressInfo userAddressInfo);

    Integer countByHouse(String house);

    UserBaseInfo getBaseInfo();

    Boolean updateEmail(String email);
}
