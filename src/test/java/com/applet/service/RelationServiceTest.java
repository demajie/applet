package com.applet.service;


import com.applet.bean.entity.Relation;
import com.applet.mapper.RelationMapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationServiceTest {
    @Autowired
    RelationService relationService;

    @Autowired
    RelationMapper relationMapper;

    @Test
    public void test1(){
        Relation relation = new Relation();
        relation.setAdminId(5);
        relation.setUserId(5);
        relationService.cancelRelation(relation);
    }

    @Test
    public void test2() {
        System.out.println(relationMapper.isRelationed(5,1));
    }
}
