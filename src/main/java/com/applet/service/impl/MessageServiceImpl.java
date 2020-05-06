package com.applet.service.impl;

import com.applet.bean.entity.Message;
import com.applet.bean.vo.MessageInfo;
import com.applet.mapper.MessageMapper;
import com.applet.service.MessageService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
        implements MessageService {
    @Override
    public List<MessageInfo> getAllMessage() {
        return null;
    }

    @Override
    public List<MessageInfo> getDayMessage() {
        return null;
    }
}
