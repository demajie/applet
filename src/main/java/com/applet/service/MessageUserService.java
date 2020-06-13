package com.applet.service;

import com.applet.bean.dto.AnnoConditionInfo;
import com.applet.bean.entity.MessageUser;
import com.applet.bean.vo.MessageInfo;
import com.applet.mapper.MessageUserMapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/6/1 11:36
 */
public interface MessageUserService extends IService<MessageUser> {
    Boolean annoMessageCondition(AnnoConditionInfo info,List<Integer> buildingId,List<Integer> unitId);

    List<MessageUser> getMessageByAnnoId(Integer annoId);
}
