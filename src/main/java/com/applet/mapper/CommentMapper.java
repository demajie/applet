package com.applet.mapper;

import com.applet.bean.entity.Comment;
import com.applet.bean.entity.Reply;
import com.applet.bean.entity.User;
import com.applet.bean.vo.CommentDetailInfo;
import com.applet.bean.vo.CommentSimpleInfo;
import com.applet.bean.vo.ReplyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gsj
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     *  查询社区内【已办理】留言简单信息
     */
    List<CommentSimpleInfo> getDealedCommentSimpleInfos(Integer communityId,@Param("type") String type,
                                                        @Param("timeRange") Integer timeRange);


    /**
     * 根据条件查询社区内【待办理】留言简单信息
     */
    List<CommentSimpleInfo> getUnDealedCommentSimpleInfos(Integer communityId,@Param("type") String type,
                                                          @Param("timeRange") Integer timeRange);

    /**
     *  根据条件获取留言人员信息
     */
    User getUserInfo(Integer userId);

    /**
     *  根据条件查询我发布的留言
     */
    List<CommentSimpleInfo> getMyCommentSimpleInfos(@Param("userId") Integer userId,@Param("type") String type,
                                                   @Param("timeRange") Integer timeRange);

    /**
     *  获取留言详细信息
     */
    CommentDetailInfo getCommentDetailInfo(Integer commentId);

    /**
     *  查询留言回复信息
     */
    List<ReplyInfo> listReply(Integer commentId);
}
