package com.applet.controller;

import com.applet.bean.vo.BuildingInfo;
import com.applet.bean.vo.UnitInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/5/8 9:23
 */
@RestController
@Api(tags = "单元API")
@RequestMapping("api/unit")
public class UnitController {
    @Autowired
    UnitService unitService;

    @ApiOperation("查看当前楼栋的所有单元")
    @GetMapping("getAll")
    public JsonWrapper<List<UnitInfo>> getAll(Integer buildingId) {
        return new JsonWrapper<>(unitService.getAll(buildingId));
    }
}
