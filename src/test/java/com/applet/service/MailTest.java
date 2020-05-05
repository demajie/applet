package com.applet.service;


import com.applet.utils.MailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Test
    public void test1() {
        MailUtils.sendMail("2410252220@qq.com","消息测试","123456789");
    }
}
