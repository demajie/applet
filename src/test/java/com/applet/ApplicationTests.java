package com.applet;


import com.applet.bean.entity.Message;
import com.applet.service.MessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    MessageService messageService;

    @Test
    void contextLoads() {
        List<Message> list = messageService.list();
        LocalDateTime time = LocalDateTime.of(2000, 10, 1, 10, 10);
        for (Message message : list) {
            System.out.println(message.getAnnoTime().isAfter(time));
        }

    }

}
