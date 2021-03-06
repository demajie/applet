package com.applet.controller;


import com.applet.bean.dto.SuperAdminAddInfo;
import com.applet.bean.dto.UserAddBaseInfo;
import com.applet.bean.dto.UserAddressInfo;
import com.applet.bean.vo.LoginInfo;
import com.applet.bean.vo.UserBaseInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.IdMapperService;
import com.applet.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
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

    @Autowired
    IdMapperService idMapperService;

    @GetMapping("convert")
    @ApiOperation("用户openid转换转换成整型")
    @ApiImplicitParam(name = "openId",value = "用户openId",dataType = "String")
    public JsonWrapper<Integer> convert(String openId) {
        return new JsonWrapper<>(idMapperService.convert(openId));
    }

    @GetMapping("isLogin")
    @ApiOperation("判断用户是否登录过，如果登录了并返回用户级别")
    @ApiImplicitParam(name = "userId",value = "用户id",dataType = "int")
    public JsonWrapper<LoginInfo> lsLogin(Integer userId) {
        return new JsonWrapper<>(userService.lsLogin(userId));
    }

    @GetMapping("saveUser")
    @ApiOperation("加入社区，登记用户基本信息")
    public JsonWrapper<Boolean> saveUser(UserAddBaseInfo userAddBaseInfo) {
        return new JsonWrapper<>(userService.saveUser(userAddBaseInfo));
    }

    @GetMapping("saveAddressInfo")
    @ApiOperation("填写用户住址信息")
    public JsonWrapper<Boolean> saveAddressInfo(UserAddressInfo userAddressInfo) {
        return new JsonWrapper<>(userService.saveAddressInfo(userAddressInfo));
    }


    @GetMapping("saveSuperAdminInfo")
    @ApiOperation("创建社区，设置当前用户为超级管理员")
    public JsonWrapper<Boolean> saveSuperAdminInfo(SuperAdminAddInfo info) {
        return new JsonWrapper<>(userService.saveSuperAdminInfo(info));
    }

    @GetMapping("getCurrentAddress")
    @ApiOperation("普通用户获取当前住址，超级管理员不可用")
    public JsonWrapper<String> getCurrentAddress() {
        return new JsonWrapper<>(userService.getCurrentAddress());
    }


    @GetMapping("/getBaseInfo")
    @ApiOperation("返回当前用户基本信息")
    public JsonWrapper<UserBaseInfo> getBaseInfo() {
        return new JsonWrapper<>(userService.getBaseInfo());
    }

    @GetMapping("/updateEmail")
    @ApiOperation("修改当前用户邮箱")
    public JsonWrapper<Boolean> updateEmail(String email) {
        return new JsonWrapper<>(userService.updateEmail(email));
    }


}
