package com.applet.bean.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("预约实体类")
@Data
public class Appointment implements Serializable {

    private static final long serialVersionUID = 3609545316511879009L;

    @ApiModelProperty("预约事件id")
    private Integer id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户电话")
    private String phone;

    @ApiModelProperty("预约的日期,格式:2020-5-5")
    private String day;

    @ApiModelProperty("预约时间范围id:1-8")
    private String timeRangeId;

    @ApiModelProperty("预约内容")
    private String content;

    @ApiModelProperty("预约的管理人员id")
    private Integer adminId;

    @ApiModelProperty("预约的用户id")
    private Integer userId;

    @ApiModelProperty("0管理员还未阅读,1代表同意,2代表拒绝")
    private Integer status;
}
