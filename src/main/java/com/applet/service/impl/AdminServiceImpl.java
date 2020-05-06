package com.applet.service.impl;

import com.applet.bean.dto.AdminAddInfo;
import com.applet.bean.entity.Admin;
import com.applet.bean.entity.User;
import com.applet.bean.vo.AdminDetailInfo;
import com.applet.bean.vo.AdminSimpleInfo;
import com.applet.mapper.AdminMapper;
import com.applet.mapper.UserMapper;
import com.applet.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gsj
 */

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
        admin.setCommunityId(1);
        if (adminMapper.insert(admin)>0){
            return true;
        }
        return false;
    }

    /**
     *  待完善:权限验证
     */
    @Override
    public Boolean deleteAdmin(Integer id) {
        userMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateState(Integer id,Integer state) {
        Admin admin = adminMapper.selectById(id);
        admin.setState(state);
        adminMapper.updateById(admin);
        return true;
    }

    @Override
    public List<AdminSimpleInfo> getAdminSimpInfos(Integer communityId) {
        return adminMapper.getAdminSimpInfos(communityId);
    }

    @Override
    public AdminDetailInfo getAdminDetailInfo(Integer userId) {
        return adminMapper.getAdminDetailInfo(userId);
    }

}
