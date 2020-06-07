package com.applet.service;


import com.applet.bean.entity.Relation;
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

    @Test
    public void test1(){
        Relation relation = new Relation();
        relation.setAdminId(1);
        relation.setUserId(2);
        relationService.cancelRelation(relation);
    }

    @Test
    public void test2() {
        System.out.println(relationService.getRelationedUserIds(1));
    }
}
