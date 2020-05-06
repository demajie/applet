package com.applet.service.impl;

import com.applet.bean.dto.UserAddInfo;
import com.applet.bean.entity.User;
import com.applet.bean.vo.LoginInfo;
import com.applet.mapper.UserMapper;
import com.applet.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Override
    public LoginInfo lsLogin() {
        return null;
    }

    @Override
    public Boolean saveUser(UserAddInfo userAddInfo) {
        return null;
    }

    @Override
    public Boolean querySuperAdmin(Integer id) {
        return null;
    }
}
