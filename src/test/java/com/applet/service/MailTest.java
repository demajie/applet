package com.applet.service;


import com.applet.utils.MailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Test
    public void test1() {

        MailUtils.sendMail("541099558@qq.com","消息测试","123456789");
    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        MailUtils.sendMails(list,"t");
    }
}
