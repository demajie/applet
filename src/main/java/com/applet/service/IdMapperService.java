package com.applet.service;

import com.applet.bean.entity.IdMapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author LuckyCurve
 * @date 2020/5/17 21:44
 */
public interface IdMapperService extends IService<IdMapper> {
    Integer convert(String openId);
}
