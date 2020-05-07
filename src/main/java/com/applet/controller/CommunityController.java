package com.applet.controller;

import com.applet.bean.dto.CommunityAddInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.CommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuckyCurve
 * @date 2020/5/5 16:06
 */
@Api(tags = "社区API")
@RestController
@RequestMapping("api/community")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @ApiOperation("创建社区")
    @GetMapping("create")
    public JsonWrapper<Boolean> create(CommunityAddInfo communityAddInfo) {
        return new JsonWrapper<>(communityService.create(communityAddInfo));
    }


}
