package com.applet.controller;


import com.applet.bean.vo.MessageInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.MessageService;
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
@Api(tags = "消息类api")
@RestController
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    MessageService getAllMessage;

    @GetMapping("getAllMessage")
    @ApiOperation("获取当前用户所有消息，不限于一天之内")
    public JsonWrapper<List<MessageInfo>> getAllMessage() {
        return new JsonWrapper<>(getAllMessage.getAllMessage());
    }

    @GetMapping("getDayMessage")
    @ApiOperation("获取当前用户单日消息")
    @ApiImplicitParam(name = "id",value = "用户的appid",dataType = "Integer")
    public JsonWrapper<List<MessageInfo>> getDayMessage() {
        return new JsonWrapper<>(getAllMessage.getDayMessage());
    }
}
