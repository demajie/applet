package com.applet.service;

//import com.applet.bean.dto.AnnoMessageInfo;
import com.applet.bean.dto.AnnoMessageInfo;
import com.applet.bean.vo.MessageInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;


/**
 * @author LuckyCurve
 * @date 2020/5/8 11:12
 */
@SpringBootTest
class MessageServiceTest {
    @Autowired
    MessageService messageService;

    @Test
    public void test() {
        AnnoMessageInfo info = AnnoMessageInfo.builder().message("测试消息").level("C").build();
        Boolean aBoolean = messageService.annoMessageCommunity(info);
        Boolean aBoolean1 = messageService.annoMessageBuilding(Collections.singletonList(1), info);
        Boolean aBoolean2 = messageService.annoMessageUnit(Collections.singletonList(1), info);
        Assertions.assertTrue(aBoolean && aBoolean1 && aBoolean2);
    }

    @Test
    public void test2(){
        messageService.deleteMessage(4);
    }
}