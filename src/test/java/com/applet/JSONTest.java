package com.applet;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.applet.bean.entity.MessageUser;
import com.applet.mapper.MessageUserMapper;
import com.applet.mapper.UserMapper;
import com.applet.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/6/1 10:55
 */
@SpringBootTest
public class JSONTest {

    @Autowired
    MessageUserMapper messageUserMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            a.add(i);
        }
        String s = JSONArray.toJSONString(a);

        List<Integer> list1 = JSONArray.parseArray(s, Integer.class);
        System.out.println(list1);
    }

    @Test
    public void test2() {
        MessageUser user = MessageUser.builder().message("测试").userList("1").annoTime(LocalDateTime.now())
                .level("A").annoUser(2).build();
        messageUserMapper.insert(user);
    }

    @Test
    public void test3() {
        System.out.println(userMapper.countByHouse("222"));
    }

}
