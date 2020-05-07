package com.applet.controller;

import com.applet.bean.dto.BuildingAddInfo;
import com.applet.bean.dto.CommunityAddInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.BuildingService;
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
 * @date 2020/5/6 14:45
 */
@Api(tags = "楼栋API")
@RestController
@RequestMapping("api/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @ApiOperation("创建楼栋")
    @GetMapping("create")
    public JsonWrapper<Boolean> create(List<BuildingAddInfo> infoList) {
        return new JsonWrapper<>(buildingService.create(infoList));
    }

}
