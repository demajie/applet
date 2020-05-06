package com.applet.service;

import com.applet.bean.dto.CommunityAddInfo;
import com.applet.bean.entity.Community;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author LuckyCurve
 * @date 2020/5/5 16:03
 */
public interface CommunityService extends IService<Community> {


    /**
     * 创建社区，并设置当前用户的community_id为当前社区id
     */
    Boolean create(CommunityAddInfo communityAddInfo);
}
