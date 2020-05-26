package com.applet.controller;

import com.applet.bean.dto.AppointmentAddInfo;
import com.applet.bean.vo.AppointmentInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.AppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gsj
 */

@Api(tags = "预约行为api")
@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @ApiOperation("添加预约")
    @PostMapping("addAppointment")
    public JsonWrapper<Boolean> addAppointment(AppointmentAddInfo appointmentInfo) {
        return new JsonWrapper<>(appointmentService.addAppointment(appointmentInfo));
    }

    @ApiOperation("管理员查看所有预约")
    @GetMapping("getAllAppointments")
    @ApiImplicitParam(name = "id",value = "管理员id", dataType = "int")
    public JsonWrapper<List<AppointmentInfo>> getAllAppointments(Integer id) {
        return new JsonWrapper<>(appointmentService.getAllAppointments(id));
    }

    @ApiOperation("管理员查看今天的所有预约")
    @GetMapping("getTodayAppointments")
    @ApiImplicitParam(name = "id",value = "管理员id", dataType = "int")
    public JsonWrapper<List<AppointmentInfo>> getTodayAppointments(Integer id) {
        return new JsonWrapper<>(appointmentService.getTodayAppointments(id));
    }

    @ApiOperation("管理员拒绝预约")
    @PostMapping("refuseAppointment")
    @ApiImplicitParam(name = "id",value = "预约事件id", dataType = "int")
    public JsonWrapper<Boolean> refuseAppointment(Integer id) {
        return new JsonWrapper<>(appointmentService.refuseAppointment(id));
    }

    @ApiOperation("管理员同意预约")
    @PostMapping("acceptAppointment")
    @ApiImplicitParam(name = "id",value = "预约事件id", dataType = "int")
    public JsonWrapper<Boolean> acceptAppointment(Integer id) {
        return new JsonWrapper<>(appointmentService.acceptAppointment(id));
    }
}
