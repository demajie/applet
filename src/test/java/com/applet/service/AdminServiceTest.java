package com.applet.service;


import com.applet.Application;
import com.applet.bean.dto.AdminAddInfo;
import com.applet.bean.vo.AdminSimpleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    /**
     * 测试添加
     */
    @Test
    public void test1() {
        AdminAddInfo info = new AdminAddInfo();
        info.setId(2);
        info.setJobDuty("tqltql");
        info.setFixedPhone("21132");
        info.setOfficeLocation("海南省");
        info.setPolitic("党员");
        info.setPosition("党委书记");
        info.setFile(new File("D:/p2.png"));
        adminService.addAdmin(info);
    }

    /**
     * 测试删除
     */
    @Test
    public void test2() {
        adminService.deleteAdmin(2);
    }

    /**
     * 测试更新状态
     */
    @Test
    public void test3() {
        adminService.updateState(1, 2);
    }

    /**
     * 获取管理员简单信息
     */
    @Test
    public void test4() {
        List<AdminSimpleInfo> list = adminService.getAdminSimpInfos(1);
        System.out.println(list);
    }

    /**
     * 获取管理员详细信息
     */
    @Test
    public void test5() {
        System.out.println(adminService.getAdminDetailInfo(1));
    }
}
