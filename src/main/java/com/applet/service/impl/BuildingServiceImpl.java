package com.applet.service.impl;

import com.applet.bean.dto.BuildingAddInfo;
import com.applet.bean.entity.Building;
import com.applet.bean.entity.Unit;
import com.applet.bean.vo.BuildingInfo;
import com.applet.mapper.BuildingMapper;
import com.applet.service.BuildingService;
import com.applet.service.UnitService;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/5/7 11:29
 */
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {

    @Autowired
    UnitService unitService;

    @Override
    public Boolean create(BuildingAddInfo info) {

        Integer communityId = RequestUtils.getCurrentCommunityId();

        //创建楼栋
        Building building = Building.builder().name(info.getName()).communityId(communityId).build();
        save(building);

        //循环创建所属楼栋的单元
        List<Unit> units = new LinkedList<>();
        for (int i = 0; i < info.getNum(); i++) {
            Unit unit = Unit.builder().buildingId(building.getId()).name(String.valueOf(i + 1)).build();
            units.add(unit);
        }
        unitService.saveBatch(units);

        return true;
    }

    @Override
    public List<BuildingInfo> getAll() {
        QueryWrapper<Building> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id", RequestUtils.getCurrentCommunityId());
        List<Building> list = list(wrapper);
        LinkedList<BuildingInfo> list1 = new LinkedList<>();
        for (Building i : list) {
            BuildingInfo build = BuildingInfo.builder().id(i.getId()).name(i.getName()).build();
            list1.add(build);
        }
        return list1;
    }
}
