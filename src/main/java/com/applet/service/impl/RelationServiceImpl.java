package com.applet.service.impl;

import com.applet.bean.entity.Relation;
import com.applet.mapper.RelationMapper;
import com.applet.service.RelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements RelationService {

    @Autowired
    RelationMapper relationMapper;

    @Override
    public Boolean createRelation(Relation relation) {
        if ()

        relationMapper.insert(relation);
        return true;
    }

    @Override
    public Boolean cancelRelation(Relation relation) {
        relationMapper.cancelRelation(relation.getAdminId(),relation.getUserId());
        return true;
    }

    @Override
    public List<Integer> getRelationedUserIds(Integer adminId) {
        return relationMapper.getRelationedUserIds(adminId);
    }
}
