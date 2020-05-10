package com.applet.service;


import com.applet.bean.dto.CommentAddInfo;
import com.applet.bean.dto.ReplyAddInfo;
import com.applet.bean.entity.Comment;
import com.applet.bean.vo.CommentDetailInfo;
import com.applet.bean.vo.CommentSimpleInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.lang.Nullable;

import java.util.List;

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
     *  管理员回复留言,待完善:回复留言的权限校验
     */
    Boolean addReply(ReplyAddInfo addInfo);

    /**
     *  根据条件查询社区内【已办理】留言简单信息
     */
    List<CommentSimpleInfo> getDealedCommentSimpleInfos(Integer communityId,Integer typeId,Integer timeRangeId);

    /**
     * 根据条件查询社区内【待办理】留言简单信息
     */
    List<CommentSimpleInfo> getUnDealedCommentSimpleInfos(Integer communityId,Integer typeId,Integer timeRangeId);

    /**
     *  根据条件查询我发布的留言
     */
    List<CommentSimpleInfo> getMyCommentSimpleInfos(Integer userId,Integer typeId,Integer timeRangeId);

    /**
     * 查询留言详细信息
     */
    CommentDetailInfo getCommentDetailInfo(Integer commentId);
}
