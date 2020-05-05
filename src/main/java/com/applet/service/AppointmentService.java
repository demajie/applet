package com.applet.service;

import com.applet.bean.dto.AppointmentInfo;
import com.applet.bean.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  预约行为
 */
public interface AppointmentService extends IService<Appointment> {
    /**
     *  添加预约
     */
    Boolean addAppointment(AppointmentInfo appointmentInfo);

}
