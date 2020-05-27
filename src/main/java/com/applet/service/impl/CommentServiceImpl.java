package com.applet.service.impl;

import com.applet.bean.dto.CommentAddInfo;
import com.applet.bean.dto.ReplyAddInfo;
import com.applet.bean.entity.Comment;
import com.applet.bean.entity.Reply;
import com.applet.bean.vo.AdminDetailInfo;
import com.applet.bean.vo.CommentDetailInfo;
import com.applet.bean.vo.CommentSimpleInfo;
import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;
import com.applet.mapper.AdminMapper;
import com.applet.mapper.CommentMapper;
import com.applet.mapper.ReplyMapper;
import com.applet.mapper.UserMapper;
import com.applet.service.CommentService;
import com.applet.utils.CommentUtils;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author gsj
 * 留言板行为
 */

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Boolean addComment(CommentAddInfo commentAddInfo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentAddInfo,comment);
        comment.setType(CommentUtils.getType(commentAddInfo.getTypeId()));
        comment.setDay(new Date());
        comment.setUserId(RequestUtils.getCurrentUserId());
        comment.setCommunityId(RequestUtils.getCurrentCommunityId());
        commentMapper.insert(comment);
        return true;
    }


    @Override
    public Boolean addReply(ReplyAddInfo addInfo) {
        if (RequestUtils.getCurrentPermId()!=1 && RequestUtils.getCurrentPermId()!=2){
            throw new KnownException(ExceptionEnum.NO_PERMISSION);
        }
        /**
         * 添加回复
         */
        Reply reply = new Reply();
        BeanUtils.copyProperties(addInfo,reply);
        reply.setDay(new Date());
        replyMapper.insert(reply);

        /**
         *  更改留言状态
         */
        Comment comment = commentMapper.selectById(addInfo.getCommentId());
        comment.setStatus(addInfo.getStatus());
        comment.setAdminId(RequestUtils.getCurrentUserId());
        commentMapper.updateById(comment);
        return true;
    }

    @Override
    public List<CommentSimpleInfo> getDealedCommentSimpleInfos(Integer communityId,Integer typeId,Integer timeRangeId) {
        List<CommentSimpleInfo> commentSimpleInfos = commentMapper.getDealedCommentSimpleInfos(communityId,CommentUtils.getType(typeId),CommentUtils.getTimeRange(timeRangeId));
        for (CommentSimpleInfo commentSimpleInfo:commentSimpleInfos){
            commentSimpleInfo.setFirstName(CommentUtils.getFirstName(commentSimpleInfo.getUser()));
        }
        return commentSimpleInfos;
    }

    @Override
    public List<CommentSimpleInfo> getUnDealedCommentSimpleInfos(Integer communityId,Integer typeId,Integer timeRangeId) {
        List<CommentSimpleInfo> commentSimpleInfos = commentMapper.getUnDealedCommentSimpleInfos(communityId,CommentUtils.getType(typeId),CommentUtils.getTimeRange(timeRangeId));
        for (CommentSimpleInfo commentSimpleInfo:commentSimpleInfos){
            commentSimpleInfo.setFirstName(CommentUtils.getFirstName(commentSimpleInfo.getUser()));
            commentSimpleInfo.setCanDeal(CommentUtils.hasPriorityToDeal(commentSimpleInfo));
        }
        return commentSimpleInfos;
    }

    @Override
    public List<CommentSimpleInfo> getMyCommentSimpleInfos(Integer userId,Integer typeId,Integer timeRangeId) {
        List<CommentSimpleInfo> commentSimpleInfos = commentMapper.getMyCommentSimpleInfos(userId,CommentUtils.getType(typeId),CommentUtils.getTimeRange(timeRangeId));
        for (CommentSimpleInfo commentSimpleInfo:commentSimpleInfos){
            commentSimpleInfo.setFirstName(CommentUtils.getFirstName(commentSimpleInfo.getUser()));
        }
        return commentSimpleInfos;
    }

    @Override
    public CommentDetailInfo getCommentDetailInfo(Integer commentId) {
        CommentDetailInfo detailInfo = commentMapper.getCommentDetailInfo(commentId);
        Integer userId = detailInfo.getUserId();
        Integer adminId = detailInfo.getAdminId();
        detailInfo.setName(userMapper.selectById(userId).getName());
        detailInfo.setAdminName(adminMapper.selectById(adminId).getName());
        detailInfo.setAddress(RequestUtils.getAddressByUserId(userId));
        return detailInfo;
    }


}
