package com.applet.service;

import com.applet.bean.dto.AnnoConditionInfo;
import com.applet.bean.dto.AnnoMessageInfo;
import com.applet.bean.entity.Message;
import com.applet.bean.vo.MessageInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
 * @author LuckyCurve
 */
public interface MessageService extends IService<Message> {

    /**
     * 返回当前用户所有消息
     */
    List<MessageInfo> getAllMessage();

    /**
     * 获取当前用户单日消息
     */
    List<MessageInfo> getDayMessage();

    /**
     * 发布消息到当前社区
     */
    Boolean annoMessageCommunity(AnnoMessageInfo info);

    /**
     * 发布消息到指定楼栋
     */
    Boolean annoMessageBuilding(List<Integer> buildingId,AnnoMessageInfo info);

    /**
     * 发布消息到指定单元
     */
    Boolean annoMessageUnit(List<Integer> unitId,AnnoMessageInfo info);

    Boolean deleteMessage(Integer messageId);
}
