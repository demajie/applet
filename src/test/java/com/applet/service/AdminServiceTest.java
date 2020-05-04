package com.applet.service;


import com.applet.Application;
import com.applet.bean.dto.AdminAddInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    public void test1() {
        AdminAddInfo info = new AdminAddInfo();
        info.setId(1);
        info.setFixed_phone("21132");
        info.setOffice_location("湖北省");
        info.setPolitic("党员");
        info.setPosition("宣传部部长");
        adminService.addAdmin(info);
    }
}
