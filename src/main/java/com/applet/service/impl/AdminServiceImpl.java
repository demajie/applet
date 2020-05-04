package com.applet.service.impl;

import com.applet.bean.dto.AdminAddInfo;
import com.applet.bean.entity.Admin;
import com.applet.bean.entity.User;
import com.applet.mapper.AdminMapper;
import com.applet.mapper.UserMapper;
import com.applet.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UserMapper userMapper;


    /**
     *  待完善:权限验证
     */
    @Override
    public Boolean addAdmin(AdminAddInfo adminAddInfo) {
        Integer id = adminAddInfo.getId();
        User user = userMapper.selectById(id);
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminAddInfo,admin);
        admin.setEmail(user.getEmail());
        admin.setName(user.getName());
        if (adminMapper.insert(admin)>0){
            return true;
        }
        return false;
    }

    /**
     *  权限验证
     */
    @Override
    public Boolean deleteAdmin(Integer id) {
        userMapper.deleteById(id);
        return true;
    }
}
