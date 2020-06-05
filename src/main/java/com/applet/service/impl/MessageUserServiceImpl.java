package com.applet.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.applet.bean.dto.AnnoConditionInfo;
import com.applet.bean.entity.MessageUser;
import com.applet.bean.entity.User;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.mapper.MessageUserMapper;
import com.applet.mapper.UserMapper;
import com.applet.service.MessageUserService;
import com.applet.service.UserService;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LuckyCurve
 * @date 2020/6/1 11:37
 */
@Service
public class MessageUserServiceImpl extends ServiceImpl<MessageUserMapper, MessageUser> implements MessageUserService {

    @Autowired
    UserService userService;

    @Override
    public Boolean annoMessageCondition(AnnoConditionInfo info, List<Integer> buildingId, List<Integer> unitId) {
        //权限管理
        Integer permId = RequestUtils.getCurrentPermId();
        if (permId == 0) {
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (buildingId != null) {
            wrapper.in("building_id", buildingId);
        }
        if (unitId != null) {
            wrapper.or().in("unit_id", unitId);
        }
        if (Objects.equals("男", info.getGender())) {
            wrapper.eq("gender", "男");
        } else if (Objects.equals("女", info.getGender())) {
            wrapper.eq("gender", "女");
        }
        List<User> list = userService.list(wrapper);
        List<User> list1 = list.parallelStream().filter((user) -> {
            LocalDateTime time = user.getBirthday();
            Date date = Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
            int age = DateUtil.ageOfNow(date);
            return age < info.getMaxAge() && age > info.getMinAge();
        }).collect(Collectors.toList());

        //如果要筛选房间人数
        if (info.getBool()) {
            //筛选出满足条件的house
            ArrayList<String> list2 = new ArrayList<>();
            for (User user : list1) {
                Integer temp = userService.countByHouse(user.getHouseNum());
                if (temp < info.getMaxNum() && temp > info.getMinNum()) {
                    list2.add(user.getHouseNum());
                }
            }

            ArrayList<Integer> users = new ArrayList<>();
            for (String house : list2) {
                QueryWrapper<User> wrapper1 = new QueryWrapper<>();
                wrapper1.eq("house_num", house);
                for (User user : userService.list(wrapper1)) {
                    if (!users.contains(user.getId())) {
                        users.add(user.getId());
                    }
                }
            }

            //数据持久化
            MessageUser message = MessageUser.builder().message(info.getMessage())
                    .annoUser(RequestUtils.getCurrentUserId())
                    .level(info.getLevel())
                    .annoTime(LocalDateTime.now())
                    .userList(JSONArray.toJSONString(users))
                    .build();
            save(message);
            return true;
        }

        //不筛选房间人数
        ArrayList<Integer> users = new ArrayList<>();
        for (User user : list1) {
            users.add(user.getId());
        }
        //数据持久化
        MessageUser message = MessageUser.builder().message(info.getMessage())
                .annoUser(RequestUtils.getCurrentUserId())
                .level(info.getLevel())
                .annoTime(LocalDateTime.now())
                .userList(JSONArray.toJSONString(users))
                .build();
        save(message);

        return true;
    }
}
