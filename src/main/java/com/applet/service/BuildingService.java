package com.applet.service;

import com.applet.bean.dto.BuildingAddInfo;
import com.applet.bean.entity.Building;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/5/6 14:46
 */
public interface BuildingService extends IService<Building> {
    /**
     * 创建楼栋，并通过用户的community_id绑定到对应社区
     * 并调用单元创建方法，与该楼栋绑定
     */
    Boolean create(List<BuildingAddInfo> num);
}
