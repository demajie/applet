package com.applet.controller;


import com.applet.bean.dto.AnnoConditionInfo;
import com.applet.bean.dto.AnnoMessageInfo;
import com.applet.bean.vo.MessageInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.MessageService;
import com.applet.service.MessageUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @author LuckyCurve
 */
@Api(tags = "消息类api")
@RestController
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    MessageUserService messageUserService;

    @GetMapping("annoMessageCommunity")
    @ApiOperation("管理员，发布消息到当前社区")
    public JsonWrapper<Boolean> annoMessageCommunity(AnnoMessageInfo info) {
        return new JsonWrapper<>(messageService.annoMessageCommunity(info));
    }

    @GetMapping("annoMessageBuilding")
    @ApiOperation("管理员，发布消息到指定楼栋")
    @ApiImplicitParam(name = "buildingId",value = "楼栋id")
    public JsonWrapper<Boolean> annoMessageBuilding(@RequestParam(name = "buildingId") List<Integer> buildingId,AnnoMessageInfo info) {
        return new JsonWrapper<>(messageService.annoMessageBuilding(buildingId,info));
    }

    @GetMapping("annoMessageUnit")
    @ApiOperation("管理员，发布消息到指定单元")
    @ApiImplicitParam(name = "unitId",value = "单元id")
    public JsonWrapper<Boolean> annoMessageUnit(@RequestParam(name = "unitId") List<Integer> unitId, AnnoMessageInfo info) {
        return new JsonWrapper<>(messageService.annoMessageUnit(unitId,info));
    }

    @GetMapping("deleteMessage")
    @ApiOperation("管理员，删除消息")
    @ApiImplicitParam(name = "messageId",value = "消息id")
    public JsonWrapper<Boolean> deleteMessage(Integer messageId) {
        return new JsonWrapper<>(messageService.deleteMessage(messageId));
    }

    @GetMapping("annoMessageCondition")
    @ApiOperation("管理员，根据条件发布到User")
    public JsonWrapper<Boolean> annoMessageCondition(AnnoConditionInfo info,
                                                     @RequestParam(name = "buildingId",required = false) List<Integer> buildingId,
                                                     @RequestParam(name = "unitId",required = false) List<Integer> unitId) {
        return new JsonWrapper<>(messageUserService.annoMessageCondition(info,buildingId,unitId));
    }


    @GetMapping("getTimedMessage")
    @ApiOperation("普通用户，查询指定时间内消息")
    public JsonWrapper<List<MessageInfo>> getAllMessage(LocalDateTime start,LocalDateTime end) {
        return new JsonWrapper<>(messageService.getAllMessage(start,end));
    }

    @GetMapping("getDayMessage")
    @ApiOperation("普通用户，查询单日消息")
    public JsonWrapper<List<MessageInfo>> getDayMessage(){
        return new JsonWrapper<>(messageService.getDayMessage());
    }

}
