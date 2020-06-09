package com.applet.mapper;

import com.applet.bean.entity.Relation;
import com.applet.bean.vo.AdminDetailInfo;
import com.applet.bean.vo.AdminSimpleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gsj
 */

public interface RelationMapper extends BaseMapper<Relation> {
    void cancelRelation(@Param("adminId") Integer adminId,@Param("userId") Integer userId);

    List<Integer> getRelationedUserIds(@Param("adminId") Integer adminId);

    int isRelationed(@Param("adminId") Integer adminId, @Param("userId") Integer userId);
}
