package com.applet.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.applet.bean.dto.CommunityAddInfo;
import com.applet.bean.entity.Community;
import com.applet.bean.entity.User;
import com.applet.mapper.CommunityMapper;
import com.applet.service.CommunityService;
import com.applet.service.UserService;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LuckyCurve
 * @date 2020/5/7 11:33
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService {

    @Autowired
    UserService userService;

    @Override
    public Boolean create(CommunityAddInfo communityAddInfo) {
        Community community;
        Integer id;
        do {
            String numbers = RandomUtil.randomNumbers(6);
            id = Integer.parseInt(numbers);
            community = getById(id);
        } while (community != null);

        //创建社区
        Community community1 = Community.builder().id(id)
                .address(communityAddInfo.getAddress())
                .name(communityAddInfo.getName())
                .build();

        //绑定用户
        Integer userId = RequestUtils.getCurrentUserId();
        User user = userService.getById(userId);
        user.setCommunityId(id);

        return save(community1) && userService.updateById(user);

    }
}
