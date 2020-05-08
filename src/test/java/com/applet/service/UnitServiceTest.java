package com.applet.service;

import com.applet.bean.vo.UnitInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LuckyCurve
 * @date 2020/5/8 9:51
 */
@SpringBootTest
class UnitServiceTest {

    @Autowired
    UnitService unitService;

    @Test
    public void test() {
        for (UnitInfo info : unitService.getAll(1)) {
            System.out.println(info);
        }
    }
}