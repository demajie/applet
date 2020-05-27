package com.applet.service.impl;


import com.applet.bean.dto.AppointmentAddInfo;
import com.applet.bean.entity.Appointment;
import com.applet.bean.entity.User;
import com.applet.bean.vo.AppointmentInfo;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.mapper.AppointmentMapper;
import com.applet.mapper.UserMapper;
import com.applet.service.AppointmentService;
import com.applet.utils.DateUtils;
import com.applet.utils.MailUtils;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gsj
 */

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment>
        implements AppointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 添加预约
     */
    @Override
    public Boolean addAppointment(AppointmentAddInfo appointmentInfo) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentInfo, appointment);
        Integer userId = RequestUtils.getCurrentUserId();
        User user = userMapper.selectById(userId);
        appointment.setUserId(userId);
        appointment.setName(user.getName());
        appointment.setTimeRange(DateUtils.getTimeRange(appointmentInfo.getTimeRangeId()));
        appointment.setDay(DateUtils.strToDate(appointmentInfo.getDay()));
        if (appointmentMapper.insert(appointment) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<AppointmentInfo> getAllAppointments(Integer userId) {
        if (RequestUtils.getCurrentPermId() == 1 || RequestUtils.getCurrentPermId() == 2) {
            return appointmentMapper.getAllAppointments(RequestUtils.getCurrentUserId());
        } else {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
    }

    @Override
    public List<AppointmentInfo> getTodayAppointments(Integer userId) {
        if (RequestUtils.getCurrentPermId() == 1 || RequestUtils.getCurrentPermId() == 2) {
            return appointmentMapper.getTodayAppointments(RequestUtils.getCurrentUserId());
        } else {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }

    }

    @Override
    public Boolean acceptAppointment(Integer id) {
        if (RequestUtils.getCurrentPermId() == 1 || RequestUtils.getCurrentPermId() == 2) {
            Appointment appointment = appointmentMapper.selectById(id);
            appointment.setStatus(1);
            appointmentMapper.updateById(appointment);
            String email = userMapper.selectById(appointment.getUserId()).getEmail();
            /**
             *  发送邮件通知用户预约成功
             */
            new Thread(() -> {
                MailUtils.sendMail(email, "预约成功", "您的预约已成功");
                System.out.println("发往" + email + "的邮件成功");
            }).start();

            return true;
        }else{
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }

    }

    @Override
    public Boolean refuseAppointment(Integer id) {
        if (RequestUtils.getCurrentPermId() != 1 && RequestUtils.getCurrentPermId() != 2) {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        Appointment appointment = appointmentMapper.selectById(id);
        appointment.setStatus(2);
        appointmentMapper.updateById(appointment);
        /**
         *  发送邮件通知用户预约失败
         */
        String email = userMapper.selectById(appointment.getUserId()).getEmail();
        new Thread(() -> {
            MailUtils.sendMail(email, "预约失败", "该时段繁忙,您的预约失败");
        }).start();
        return true;
    }
}
