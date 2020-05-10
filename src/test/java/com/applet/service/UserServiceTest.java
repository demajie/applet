package com.applet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author LuckyCurve
 * @date 2020/5/9 11:58
 */
@SpringBootTest
public class UserServiceTest {


    @Autowired
    UserService userService;

    @Test
    public void test() {
        System.out.println(userService.getById(4));
    }
}
