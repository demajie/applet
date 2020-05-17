package com.applet.service.impl;

import com.applet.bean.entity.IdMapper;
import com.applet.mapper.IdMapperMapper;
import com.applet.service.IdMapperService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author LuckyCurve
 * @date 2020/5/17 21:45
 */
@Service
public class IdMapperServiceImpl extends ServiceImpl<IdMapperMapper, IdMapper> implements IdMapperService {

    @Override
    public Integer convert(String openId) {
        QueryWrapper<IdMapper> wrapper = new QueryWrapper<>();
        wrapper.eq("open_id", openId);
        IdMapper one = getOne(wrapper);
        if (one != null) {
            return one.getId();
        }
        IdMapper idMapper = IdMapper.builder().openId(openId).build();
        saveOrUpdate(idMapper);
        return idMapper.getId();
    }
}
