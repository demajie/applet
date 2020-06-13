package com.applet.mapper;

import com.applet.bean.entity.MessageUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/6/1 11:09
 */
public interface MessageUserMapper extends BaseMapper<MessageUser> {

    @Select("select * from message_user where anno_user = #{annoId} ")
    List<MessageUser> getMessageUserByAnnoId(Integer annoId);
}
