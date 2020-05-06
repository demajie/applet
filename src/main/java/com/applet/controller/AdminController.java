package com.applet.controller;

import com.applet.bean.dto.AdminAddInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gsj
 */

@Api(tags = "管理员行为")
@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @ApiOperation("添加管理员")
    @PostMapping("addAdmin")
    public JsonWrapper<Boolean> addAdmin(AdminAddInfo adminAddInfo){
        return new JsonWrapper<>(adminService.addAdmin(adminAddInfo));
    }

    @ApiOperation("删除管理员")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "Integer")
    @PostMapping("deleteAdmin/{id}")
    public JsonWrapper<Boolean> deleteAdmin(@PathVariable("id")Integer id){
        return new JsonWrapper<>(adminService.deleteAdmin(id));
    }

    @ApiOperation("获取小区邀请码")
    @GetMapping("getCommunityInvitationCode")
    public JsonWrapper<String> communityInvitationCode(){
        return null;
    }


}
