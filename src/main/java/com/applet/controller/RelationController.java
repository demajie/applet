package com.applet.controller;


import com.applet.bean.dto.AnnoMessageInfo;
import com.applet.bean.entity.Relation;
import com.applet.common.JsonWrapper;
import com.applet.service.RelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "返回提醒类api")
@RestController
@RequestMapping("api/relation")
public class RelationController {

    @Autowired
    RelationService relationService;

    @GetMapping("createRelation")
    @ApiOperation("用户开启返回提醒")
    public JsonWrapper<Boolean> createRelation(Relation relation) {
        return new JsonWrapper<>(relationService.createRelation(relation));
    }

    @GetMapping("cancelRelation")
    @ApiOperation("用户关闭返回提醒")
    public JsonWrapper<Boolean> cancelRelation(Relation relation) {
        return new JsonWrapper<>(relationService.cancelRelation(relation));
    }
}
