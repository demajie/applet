package com.applet.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.applet.bean.dto.AnnoConditionInfo;
import com.applet.bean.dto.AnnoMessageInfo;
import com.applet.bean.entity.Message;
import com.applet.bean.entity.MessageUser;
import com.applet.bean.entity.User;
import com.applet.bean.vo.MessageInfo;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.mapper.MessageMapper;
import com.applet.service.MessageService;
import com.applet.service.MessageUserService;
import com.applet.service.UserService;
import com.applet.utils.MessageInfoUtils;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LuckyCurve
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
        implements MessageService {

    /**
     * 消息id阈值，如果超过了阈值就说明消息在message_user表中
     */
    public static final Integer SEG_VALUE = 100000;

    public static final String DEPART_CHAR = "&";

    @Autowired
    UserService userService;

    @Autowired
    MessageUserService messageUserService;

    @Override
    public List<MessageInfo> getAllMessage(LocalDateTime start, LocalDateTime end) {
        Integer userId = RequestUtils.getCurrentUserId();
        User user = userService.getById(userId);
        Integer communityId = user.getCommunityId();
        Integer buildingId = user.getBuildingId();
        Integer unitId = user.getUnitId();
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id", communityId).or().eq("building_id", buildingId)
                .or().eq("unit_id", unitId).orderByDesc("anno_time");
        List<Message> messages = list(wrapper);
        LinkedList<MessageInfo> list = new LinkedList<>();
        for (Message i : messages) {
            String name = userService.getById(i.getAnnoUser()).getName();
            MessageInfo info = MessageInfo.builder().id(i.getId()).message(i.getMessage())
                    .annoTime(i.getAnnoTime()).level(i.getLevel()).annoUser(name)
                    .build();
            list.add(info);
        }

        //插入对用户消息的单独筛选
        List<MessageUser> list1 = messageUserService.list();
        for (MessageUser messageUser : list1) {
            List<Integer> listUser = JSONArray.parseArray(messageUser.getUserList(), Integer.class);
            if (listUser.contains(userId)) {
                String name = userService.getById(messageUser.getAnnoUser()).getName();
                MessageInfo messageInfo = new MessageInfo();
                BeanUtils.copyProperties(messageUser, messageInfo);
                messageInfo.setAnnoUser(name);
                list.add(messageInfo);
            }
        }

        //根绝时间过滤消息
        List<MessageInfo> list2 = list.stream().filter(a -> a.getAnnoTime().isAfter(start)&& a.getAnnoTime().isBefore(end))
                .collect(Collectors.toList());

        //分离消息头体
        for (MessageInfo info : list2) {
            String[] split = info.getMessage().split(DEPART_CHAR);
            info.setTitle(split[0]);
            info.setMessage(split[1]);
        }

        return MessageInfoUtils.sort(list2);
    }

    @Override
    public List<MessageInfo> getDayMessage() {
        Integer userId = RequestUtils.getCurrentUserId();
        User user = userService.getById(userId);
        Integer communityId = user.getCommunityId();
        Integer buildingId = user.getBuildingId();
        Integer unitId = user.getUnitId();
        LocalDate now = LocalDate.now();
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id", communityId).gt("anno_time", now).or().eq("building_id", buildingId).gt("anno_time", now)
                .or().eq("unit_id", unitId).gt("anno_time", now).orderByDesc("anno_time");
        List<Message> messages = list(wrapper);
        LinkedList<MessageInfo> list = new LinkedList<>();
        for (Message i : messages) {
            String name = userService.getById(i.getAnnoUser()).getName();
            MessageInfo info = MessageInfo.builder().id(i.getId()).message(i.getMessage())
                    .annoTime(i.getAnnoTime()).level(i.getLevel()).annoUser(name)
                    .build();
            list.add(info);
        }

        //插入对用户消息的单独筛选
        QueryWrapper<MessageUser> wrapper2 = new QueryWrapper<>();
        wrapper2.gt("anno_time", now);
        List<MessageUser> list1 = messageUserService.list(wrapper2);
        for (MessageUser messageUser : list1) {
            List<Integer> listUser = JSONArray.parseArray(messageUser.getUserList(), Integer.class);
            if (listUser.contains(userId)) {
                String name = userService.getById(messageUser.getAnnoUser()).getName();
                MessageInfo messageInfo = new MessageInfo();
                BeanUtils.copyProperties(messageUser, messageInfo);
                messageInfo.setAnnoUser(name);
                list.add(messageInfo);
            }
        }

        //消息头体分离
        for (MessageInfo info : list) {
            String[] split = info.getMessage().split(DEPART_CHAR);
            info.setTitle(split[0]);
            info.setMessage(split[1]);
        }


        return MessageInfoUtils.sort(list);
    }

    @Override
    public Boolean annoMessageCommunity(AnnoMessageInfo info) {
        //判断用户权限
        User user = userService.getById(RequestUtils.getCurrentUserId());
        if (user.getPermId() == 0) {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }

        Message message = Message.builder().message(info.getTitle() + DEPART_CHAR + info.getMessage()).communityId(user.getCommunityId())
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
            Message message = Message.builder().message(info.getTitle() + DEPART_CHAR + info.getMessage())
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
            Message message = Message.builder().message(info.getTitle() + DEPART_CHAR + info.getMessage())
                    .unitId(i)
                    .annoTime(LocalDateTime.now()).level(info.getLevel()).annoUser(user.getId()).build();
            list.add(message);
        }
        return saveBatch(list);
    }

    @Override
    public Boolean deleteMessage(Integer messageId) {
        if (RequestUtils.getCurrentPermId() == 0) {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        if (messageId >= SEG_VALUE) {
            return messageUserService.removeById(messageId);
        } else {
            return removeById(messageId);
        }
    }
}
