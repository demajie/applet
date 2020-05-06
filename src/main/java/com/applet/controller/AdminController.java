package com.applet.controller;

import com.applet.bean.dto.AdminAddInfo;
import com.applet.bean.vo.AdminDetailInfo;
import com.applet.bean.vo.AdminSimpleInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.AdminService;
import com.applet.utils.VerificationCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("生成小区邀请码")
    @GetMapping("createInvitationCode")
    public JsonWrapper<String> createInvitationCode(){
        return new JsonWrapper<>(VerificationCodeUtils.createInvitationCode());
    }


    @ApiOperation("更新管理员工作状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "管理员id",dataType = "Integer"),
            @ApiImplicitParam(name = "state",value = "新状态,0在岗,1出勤,2节假日")
    })
    @GetMapping("updateState/{id}")
    public JsonWrapper<Boolean> updateState(@PathVariable("id")Integer id,
             @RequestParam("state")Integer state) {
            return new JsonWrapper<>(adminService.updateState(id,state));
    }

    @ApiOperation("得到小区内【所有】管理员简单信息")
    @ApiImplicitParam(name = "communityId",value = "社区id",dataType = "Integer")
    @GetMapping("getAdminSimpInfos")
    public JsonWrapper<List<AdminSimpleInfo>> getAdminSimpInfos(Integer communityId){
        return new JsonWrapper<>(adminService.getAdminSimpInfos(communityId));
    }

    @ApiOperation("得到【一个】管理员的详细信息")
    @ApiImplicitParam(name = "id",value = "管理员id",dataType = "Integer")
    @GetMapping("getAdminDetailInfo")
    public JsonWrapper<AdminDetailInfo> getAdminDetailInfo(Integer id){
        return new JsonWrapper<>(adminService.getAdminDetailInfo(id));
    }
}
