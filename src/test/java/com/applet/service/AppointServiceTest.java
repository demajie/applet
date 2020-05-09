package com.applet.service;

import com.applet.bean.dto.AppointmentAddInfo;
import com.applet.bean.vo.AppointmentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *  预约类api测试
 * @author gsj
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppointServiceTest {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 添加预约
     */
    @Test
    public void test1()  {
        AppointmentAddInfo appointmentInfo = new AppointmentAddInfo();
        appointmentInfo.setDay("2013-1-4");
        appointmentInfo.setAdminId(1);
        appointmentInfo.setContent("我要结婚");
        appointmentInfo.setPhone("3333");
        appointmentInfo.setTimeRangeId(3);
        appointmentService.addAppointment(appointmentInfo);
    }

    /**
     *  查询所有预约
     */
    @Test
    public void test2() {
        List<AppointmentInfo> list = appointmentService.getAllAppointments(1);
        System.out.println(list);
    }

    /**
     *  查询今天的预约
     */
    @Test
    public void test3(){
        List<AppointmentInfo> list = appointmentService.getTodayAppointments(1);
        System.out.println(list);
    }

    /**
     *  管理员同意预约
     */
    @Test
    public void test4() throws InterruptedException {
        appointmentService.acceptAppointment(1);
        Thread.sleep(10000);
    }


}
