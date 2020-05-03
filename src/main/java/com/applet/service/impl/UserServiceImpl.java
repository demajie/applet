package com.applet.service.impl;

import com.applet.bean.entity.User;
import com.applet.mapper.UserMapper;
import com.applet.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}
