package com.applet.service.impl;

import com.applet.bean.dto.AnnoMessageInfo;
import com.applet.bean.entity.Message;
import com.applet.bean.entity.User;
import com.applet.bean.vo.MessageInfo;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.mapper.MessageMapper;
import com.applet.service.MessageService;
import com.applet.service.UserService;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LuckyCurve
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
        implements MessageService {

    @Autowired
    UserService userService;

    @Override
    public List<MessageInfo> getAllMessage() {
        return null;
    }

    @Override
    public List<MessageInfo> getDayMessage() {
        return null;
    }

    @Override
    public Boolean annoMessageCommunity(AnnoMessageInfo info) {
        //判断用户权限
        User user = userService.getById(RequestUtils.getCurrentUserId());
        if (user.getPermId() == 0) {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }

        Message message = Message.builder().message(info.getMessage()).communityId(user.getCommunityId())
                .annoTime(LocalDateTime.now()).level(info.getLevel()).annoUser(user.getId()).build();

        return save(message);
    }

    @Override
    public Boolean annoMessageBuilding(List<Integer> buildingId, AnnoMessageInfo info) {
        //判断用户权限
        User user = userService.getById(RequestUtils.getCurrentUserId());
        if (user.getPermId() == 0) {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        LinkedList<Message> list = new LinkedList<>();
        for (Integer i : buildingId) {
            Message message = Message.builder().message(info.getMessage())
                    .buildingId(i)
                    .annoTime(LocalDateTime.now()).level(info.getLevel()).annoUser(user.getId()).build();
            list.add(message);
        }
        return saveBatch(list);
    }

    @Override
    public Boolean annoMessageUnit(List<Integer> unitId, AnnoMessageInfo info) {
        //判断用户权限
        User user = userService.getById(RequestUtils.getCurrentUserId());
        if (user.getPermId() == 0) {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        LinkedList<Message> list = new LinkedList<>();
        for (Integer i : unitId) {
            Message message = Message.builder().message(info.getMessage())
                    .unitId(i)
                    .annoTime(LocalDateTime.now()).level(info.getLevel()).annoUser(user.getId()).build();
            list.add(message);
        }
        return saveBatch(list);
    }
}
