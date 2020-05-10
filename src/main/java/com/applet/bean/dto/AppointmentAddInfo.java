package com.applet.bean.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gsj
 */

@ApiModel("预约添加信息")
@Data
public class AppointmentAddInfo implements Serializable {

    private static final long serialVersionUID = 8703110413603174584L;

    @ApiModelProperty("预约内容")
    private String content;

    @ApiModelProperty("预约的日期,格式:2020-5-5")
    private String day;

    @ApiModelProperty("预约时间范围:1-8")
    private Integer timeRangeId;

    @ApiModelProperty("用户电话")
    private String phone;

    @ApiModelProperty("预约的管理人员id")
    private Integer adminId;

}
