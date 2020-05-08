package com.applet.service.impl;

import com.applet.bean.entity.Unit;
import com.applet.bean.vo.UnitInfo;
import com.applet.mapper.UnitMapper;
import com.applet.service.UnitService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/5/7 15:00
 */
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements UnitService {
    @Override
    public List<UnitInfo> getAll(Integer buildingId) {
        QueryWrapper<Unit> wrapper = new QueryWrapper<>();
        wrapper.eq("building_id",buildingId);
        LinkedList<UnitInfo> list = new LinkedList<>();
        List<Unit> units = list(wrapper);
        for (Unit unit : units) {
            UnitInfo info = UnitInfo.builder().id(unit.getId()).name(unit.getName()).build();
            list.add(info);
        }
        return list;
    }
}
