package com.applet.mapper;

import com.applet.bean.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper extends BaseMapper<Message> {

    @Select("select * from message where anno_user = #{annoId} ")
    List<Message> findByAnnoId(Integer annoId);
}
