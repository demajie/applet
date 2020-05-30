package com.applet.bean.vo;

import com.applet.bean.entity.Reply;
import com.applet.bean.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@ApiModel("留言详细信息")
@ToString(exclude = {"userId","adminId"})
@JsonIgnoreProperties(value = "handler")
public class CommentDetailInfo implements Serializable {
    private static final long serialVersionUID = 103254377490594752L;

    @ApiModelProperty("留言id")
    private Integer id;

    @ApiModelProperty("留言标题")
    private String title;

    @ApiModelProperty("留言内容")
    private String content;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("留言日期")
    private String day;

    @ApiModelProperty("0:未接件,1:办理中,2:已办理")
    private Integer status;

    @ApiModelProperty("留言人的姓名")
    private String name;

    @ApiModelProperty("接件人姓名")
    private String adminName;

    @ApiModelProperty("用户住址")
    private String address;

    private Integer userId;

    private Integer adminId;

    @ApiModelProperty("管理员回复")
    private List<ReplyInfo> replyList;
}
