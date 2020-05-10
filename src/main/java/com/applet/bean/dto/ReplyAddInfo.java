package com.applet.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gsj
 */

@Data
@ApiModel("留言回复信息")
public class ReplyAddInfo implements Serializable {

    private static final long serialVersionUID = -8313777733560534787L;

    @ApiModelProperty("1:在处理时的回复,2:处理完时的回复")
    private Integer status;

    @ApiModelProperty("回复内容")
    private String content;

    @ApiModelProperty("回复的留言的id")
    private Integer commentId;
}
