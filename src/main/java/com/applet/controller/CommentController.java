package com.applet.controller;


import com.applet.bean.dto.CommentAddInfo;
import com.applet.bean.dto.ReplyAddInfo;
import com.applet.bean.vo.CommentDetailInfo;
import com.applet.bean.vo.CommentSimpleInfo;
import com.applet.common.JsonWrapper;
import com.applet.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "留言板行为api")
@RequestMapping("api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("addComment")
    @ApiOperation("添加留言")
    public JsonWrapper<Boolean> addComment(CommentAddInfo commentAddInfo){
        return new JsonWrapper<>(commentService.addComment(commentAddInfo));
    }

    @PostMapping("addReply")
    @ApiOperation("管理员回复留言")
    public JsonWrapper<Boolean> addReply(ReplyAddInfo replyAddInfo){
        return new JsonWrapper<>(commentService.addReply(replyAddInfo));
    }

    @GetMapping("getDealedCommentSimpleInfos")
    @ApiOperation("根据条件查询社区内【已办理】留言简单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "communityId",value = "社区Id",type = "Integer"),
            @ApiImplicitParam(name = "typeId",value = "类型Id,1饮食,2环境,3服务",type = "Integer"),
            @ApiImplicitParam(name = "timeRangeId",value = "时间范围id,1一周内,2一月内,3半年内,4一年内",type = "Integer")
    })
    public JsonWrapper<List<CommentSimpleInfo>> getDealedCommentSimpleInfos(Integer communityId,Integer typeId,Integer timeRangeId){
        return new JsonWrapper<>(commentService.getDealedCommentSimpleInfos(communityId, typeId, timeRangeId));
    }

    @GetMapping("getUnDealedCommentSimpleInfos")
    @ApiOperation("根据条件查询社区内【待办理】留言简单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "communityId",value = "社区Id",type = "int"),
            @ApiImplicitParam(name = "typeId",value = "类型Id,1饮食,2环境,3服务",type = "int"),
            @ApiImplicitParam(name = "timeRangeId",value = "时间范围id,1一周内,2一月内,3半年内,4一年内",type = "int")
    })
    public JsonWrapper<List<CommentSimpleInfo>> getUnDealedCommentSimpleInfos(Integer communityId,Integer typeId,Integer timeRangeId){
        return new JsonWrapper<>(commentService.getUnDealedCommentSimpleInfos(communityId, typeId, timeRangeId));
    }

    @GetMapping("getMyCommentSimpleInfos")
    @ApiOperation("根据条件查询我发布的留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",type = "int"),
            @ApiImplicitParam(name = "typeId",value = "类型Id,1饮食,2环境,3服务",type = "int"),
            @ApiImplicitParam(name = "timeRangeId",value = "时间范围id,1一周内,2一月内,3半年内,4一年内",type = "int")
    })
    public JsonWrapper<List<CommentSimpleInfo>> getMyCommentSimpleInfos(Integer userId,Integer typeId,Integer timeRangeId){
        return new JsonWrapper<>(commentService.getMyCommentSimpleInfos(userId, typeId, timeRangeId));
    }

    @GetMapping("getCommentDetailInfo")
    @ApiOperation("查询留言详细信息")
    @ApiImplicitParam(name = "commentId",value = "留言id",type = "Integer")
    public JsonWrapper<CommentDetailInfo> getCommentDetailInfo(Integer commentId) {
        return new JsonWrapper<>(commentService.getCommentDetailInfo(commentId));
    }
}
