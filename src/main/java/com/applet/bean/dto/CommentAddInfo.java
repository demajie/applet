package com.applet.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gsj
 */

@ApiModel("留言添加信息")
@Data
public class CommentAddInfo implements Serializable {
    private static final long serialVersionUID = 4613299494407125559L;

    @ApiModelProperty("留言标题")
    private String title;

    @ApiModelProperty("留言内容")
    private String content;

    @ApiModelProperty("留言类型ID,1饮食,2环境,3服务")
    private Integer typeId;

    @ApiModelProperty("是否匿名")
    private Integer isAnonymous;

    @ApiModelProperty("联系方式")
    private String phone;
}
