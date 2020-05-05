package com.applet.controller;

import com.applet.bean.dto.AppointmentInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.AppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "预约行为api")
@RestController
@RequestMapping("api")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @ApiOperation("添加预约")
    @PostMapping("addAppointment")
    public JsonWrapper<Boolean> addAppointment(AppointmentInfo appointmentInfo) {
        return new JsonWrapper<>(appointmentService.addAppointment(appointmentInfo));
    }
}
