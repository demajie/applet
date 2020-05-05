package com.applet.service;

import com.applet.bean.entity.Message;
import com.applet.bean.vo.MessageInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author LuckyCurve
 */
public interface MessageService extends IService<Message> {

    /**
     * 返回当前用户所有消息
     */
    List<MessageInfo> getAllMessage(Integer id);

    /**
     * 获取当前用户单日消息
     */
    List<MessageInfo> getDayMessage(Integer id);
}
