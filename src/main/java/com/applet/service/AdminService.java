package com.applet.service;

import com.applet.bean.dto.AdminAddInfo;
import com.applet.bean.entity.Admin;
import com.applet.bean.vo.AdminDetailInfo;
import com.applet.bean.vo.AdminSimpleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  管理员行为
 */
public interface AdminService extends IService<Admin> {
    /**
     *  添加管理员
     */
    Boolean addAdmin(AdminAddInfo adminAddInfo);

    /**
     *  删除管理员
     */
    Boolean deleteAdmin(Integer id);


    /**
     *   更改管理员工作状态,0在岗,1出勤,2开会
     * @param id:管理员id;
     * @param state:新状态
     */
    Boolean updateState(Integer id,Integer state);


    /**
     *  得到小区内【所有】管理员简单信息
     * @param communityId:社区id
     */
    List<AdminSimpleInfo> getAdminSimpInfos(Integer communityId);


    /**
     *  得到【一个】管理员的详细信息
     * @param userId:管理员的用户id
     */
    AdminDetailInfo getAdminDetailInfo(Integer userId);
}
