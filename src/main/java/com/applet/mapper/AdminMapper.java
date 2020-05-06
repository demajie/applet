package com.applet.mapper;

import com.applet.bean.entity.Admin;
import com.applet.bean.vo.AdminDetailInfo;
import com.applet.bean.vo.AdminSimpleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author gsj
 */

public interface AdminMapper extends BaseMapper<Admin> {
    /**
     *   得到小区内【所有】管理员简单信息
     */
    List<AdminSimpleInfo> getAdminSimpInfos(Integer communityId);

    /**
     *  得到【一个】管理员的详细信息
     */
    AdminDetailInfo getAdminDetailInfo(Integer userId);
}
