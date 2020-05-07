package com.applet.service.impl;

import com.applet.bean.entity.Unit;
import com.applet.mapper.UnitMapper;
import com.applet.service.UnitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author LuckyCurve
 * @date 2020/5/7 15:00
 */
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements UnitService {
}
