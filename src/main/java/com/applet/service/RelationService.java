package com.applet.service;

import com.applet.bean.entity.Relation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  返回提醒操作类
 */
public interface RelationService extends IService<Relation> {
    Boolean createRelation(Relation relation);

    Boolean cancelRelation(Relation relation);

    List<Integer> getRelationedUserIds(Integer adminId);
}
