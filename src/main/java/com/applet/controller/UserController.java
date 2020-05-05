package com.applet.controller;


import com.applet.bean.dto.UserAddInfo;
import com.applet.bean.vo.LoginInfo;
import com.applet.bean.vo.MessageInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LuckyCurve
 */
@Api(tags = "用户行为api")
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("isLogin")
    @ApiOperation("判断用户是否登录，并返回用户级别")
    public JsonWrapper<LoginInfo> lsLogin() {
        return new JsonWrapper<>(userService.lsLogin());
    }

    @GetMapping("saveUser")
    @ApiOperation("登记用户基本信息")
    public JsonWrapper<Boolean> saveUser(UserAddInfo userAddInfo) {
        return new JsonWrapper<>(userService.saveUser(userAddInfo));
    }



}
