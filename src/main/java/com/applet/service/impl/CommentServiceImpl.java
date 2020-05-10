package com.applet.service.impl;

import com.applet.bean.dto.CommentAddInfo;
import com.applet.bean.dto.ReplyAddInfo;
import com.applet.bean.entity.Comment;
import com.applet.bean.entity.Reply;
import com.applet.mapper.CommentMapper;
import com.applet.mapper.ReplyMapper;
import com.applet.service.CommentService;
import com.applet.utils.CommentUtils;
import com.applet.utils.RequestUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public Boolean addComment(CommentAddInfo commentAddInfo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentAddInfo,comment);
        comment.setType(CommentUtils.getType(commentAddInfo.getTypeId()));
        comment.setDay(new Date());
        comment.setUserId(1);
        comment.setCommunityId(RequestUtils.getCurrentCommunityId());
        commentMapper.insert(comment);
        return true;
    }

    @Override
    public Boolean addReply(ReplyAddInfo addInfo) {
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
        comment.setAdminId(1);
        commentMapper.updateById(comment);
        return true;
    }

}
