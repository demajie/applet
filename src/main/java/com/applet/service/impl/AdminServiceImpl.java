package com.applet.service.impl;

import com.applet.bean.dto.AdminAddInfo;
import com.applet.bean.entity.Admin;
import com.applet.bean.entity.User;
import com.applet.bean.vo.AdminDetailInfo;
import com.applet.bean.vo.AdminSimpleInfo;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.mapper.AdminMapper;
import com.applet.mapper.RelationMapper;
import com.applet.mapper.UserMapper;
import com.applet.service.AdminService;
import com.applet.utils.MailUtils;
import com.applet.utils.QiniuUtils;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    @Autowired
    RelationMapper relationMapper;

    /**
     *  待完善:权限验证
     */
    @Override
    public Boolean addAdmin(AdminAddInfo adminAddInfo)  {
        if (RequestUtils.getCurrentPermId()!=2){
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        if (!QiniuUtils.checkPictureFormat(adminAddInfo.getFile().getOriginalFilename())){
            throw new KnownException(ExceptionEnum.ERROR_IMAGE_FORMAT);
        }
        Integer id = adminAddInfo.getId();

        if (adminMapper.selectById(id)!=null){
            throw new KnownException(ExceptionEnum.ADMIN_ALREADY_EXIST);
        }

        User user = userMapper.selectById(id);
        if(user==null) {
            throw new KnownException(ExceptionEnum.USER_NOT_EXIST);
        }
        user.setPermId(1);
        userMapper.updateById(user);
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminAddInfo,admin);
        admin.setEmail(user.getEmail());
        admin.setName(user.getName());
        admin.setCommunityId(RequestUtils.getCurrentCommunityId());
        try {
            admin.setPhoto(QiniuUtils.uploadPhoto(adminAddInfo.getFile().getBytes(),"avatar_"+admin.getId()));
        } catch (IOException e) {
            throw new KnownException(ExceptionEnum.FILE_IO_EXCEPTION);
        }
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
        if (RequestUtils.getCurrentPermId()!=2){
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        adminMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateState(Integer id,Integer state) {
        if (RequestUtils.getCurrentPermId()!=1){
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        Admin admin = adminMapper.selectById(id);
        admin.setState(state);
        adminMapper.updateById(admin);

        /**
         *  群发邮件
         */
        if (state==0) {
            List<Integer> userIds = relationMapper.getRelationedUserIds(id);
            MailUtils.sendMails(userIds,admin.getName());
        }


        return true;
    }

    @Override
    public List<AdminSimpleInfo> getAdminSimpInfos(Integer communityId) {
        return adminMapper.getAdminSimpInfos(communityId);
    }

    @Override
    public AdminDetailInfo getAdminDetailInfo(Integer adminId) {
        AdminDetailInfo detailInfo =  adminMapper.getAdminDetailInfo(adminId);

        if (relationMapper.isRelationed(adminId,RequestUtils.getCurrentUserId())>0){
            detailInfo.setIsRelationed(1);
        }else{
            detailInfo.setIsRelationed(0);
        }
        return  detailInfo;
    }

    @Override
    public Integer getCurrentCommunity() {
        return RequestUtils.getCurrentCommunityId();
    }

}
