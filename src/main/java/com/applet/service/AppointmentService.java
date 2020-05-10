package com.applet.service;

import com.applet.bean.dto.AppointmentAddInfo;
import com.applet.bean.entity.Appointment;
import com.applet.bean.vo.AppointmentInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  预约行为
 * @author gsj
 */
public interface AppointmentService extends IService<Appointment> {
    /**
     *  添加预约
     */
    Boolean addAppointment(AppointmentAddInfo appointmentInfo);

    /**
     *  管理员查看全部预约
     * @param userId :管理员id
     */
    List<AppointmentInfo> getAllAppointments(Integer userId);

    /**
     *  管理员查看今天的预约
     *  @param userId :管理员id
     */
    List<AppointmentInfo> getTodayAppointments(Integer userId);

    /**
     *  管理员接受预约
     * @Param 预约id
     */
    Boolean acceptAppointment(Integer id);


    /***
     *  管理员拒绝预约
     *  @Param 预约id
     */
    Boolean refuseAppointment(Integer id);
}
