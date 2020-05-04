package com.applet.service;

import com.applet.bean.dto.AdminAddInfo;
import com.applet.bean.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  管理员操作类
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
}
