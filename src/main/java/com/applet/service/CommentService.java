package com.applet.service;


import com.applet.bean.dto.CommentAddInfo;
import com.applet.bean.dto.ReplyAddInfo;
import com.applet.bean.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author gsj
 * 留言类行为
 */
public interface CommentService extends IService<Comment> {
    /**
     *  添加留言
     * @return
     */
    Boolean addComment(CommentAddInfo commentAddInfo);

    /**
     *  管理员回复留言
     */
    Boolean addReply(ReplyAddInfo addInfo);
}
