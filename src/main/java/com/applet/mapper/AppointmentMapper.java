package com.applet.mapper;

import com.applet.bean.entity.Appointment;
import com.applet.bean.vo.AppointmentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author gsj
 */

public interface AppointmentMapper extends BaseMapper<Appointment> {
    List<AppointmentInfo> getAllAppointments(Integer userId);

    List<AppointmentInfo> getTodayAppointments(Integer userId);
}
