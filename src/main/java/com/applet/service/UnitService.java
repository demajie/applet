package com.applet.service;

import com.applet.bean.entity.Unit;
import com.applet.bean.vo.UnitInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author LuckyCurve
 * @date 2020/5/7 15:00
 */
public interface UnitService extends IService<Unit>  {
    List<UnitInfo> getAll(Integer buildingId);
}
