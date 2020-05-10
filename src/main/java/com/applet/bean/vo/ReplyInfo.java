package com.applet.bean.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author gsj
 */
@Data
@ApiModel("留言回复信息")
public class ReplyInfo {
    @ApiModelProperty("回复id")
    private Integer id;

    @ApiModelProperty("1:在处理时的回复,2:处理完时的回复")
    private Integer status;

    @ApiModelProperty("回复内容")
    private String content;

    @ApiModelProperty("回复时间")
    private String day;
}
