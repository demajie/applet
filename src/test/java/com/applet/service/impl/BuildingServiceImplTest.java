package com.applet.service.impl;

import com.applet.bean.dto.BuildingAddInfo;
import com.applet.bean.entity.Building;
import com.applet.service.BuildingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LuckyCurve
 * @date 2020/5/7 15:14
 */
@SpringBootTest
class BuildingServiceImplTest {

    @Autowired
    BuildingService buildingService;

    @Test
    public void test() {
        LinkedList<BuildingAddInfo> list = new LinkedList<>();
        list.add(BuildingAddInfo.builder().name("测试楼栋").num(2).build());
        buildingService.create(list);
    }

}