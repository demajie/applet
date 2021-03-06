package com.applet.controller;

import com.applet.bean.dto.BuildingAddInfo;
import com.applet.bean.dto.CommunityAddInfo;
import com.applet.bean.vo.BuildingInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.BuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "create")
    public JsonWrapper<Boolean> create(BuildingAddInfo infoList) {
        return new JsonWrapper<>(buildingService.create(infoList));
    }

    @ApiOperation("查看当前社区所有楼栋")
    @GetMapping("getAll")
    @ApiImplicitParam(name = "communityId",value = "社区Id",dataType = "int")
    public JsonWrapper<List<BuildingInfo>> getAll(Integer communityId) {
        return new JsonWrapper<>(buildingService.getAll(communityId));
    }

}
