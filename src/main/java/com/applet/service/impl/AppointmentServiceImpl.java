package com.applet.service.impl;


import com.applet.bean.dto.AppointmentInfo;
import com.applet.bean.entity.Appointment;
import com.applet.bean.entity.User;
import com.applet.mapper.AppointmentMapper;
import com.applet.mapper.UserMapper;
import com.applet.service.AppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment>
        implements AppointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    UserMapper userMapper;

    /**
     *  待完善,获取真实的用户id
     *  获取预约的管理员id
     */
    @Override
    public Boolean addAppointment(AppointmentInfo appointmentInfo) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentInfo,appointment);
        Integer id = 1;
        User user = userMapper.selectById(id);
        appointment.setId(id);
        appointment.setName(user.getName());
        appointment.setAdminId(2);
        if (appointmentMapper.insert(appointment)>0){
            return true;
        }
        return false;
    }
}
