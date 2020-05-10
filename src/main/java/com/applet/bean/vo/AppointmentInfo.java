package com.applet.bean.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gsj
 */

@ApiModel("预约信息")
@Data
public class AppointmentInfo implements Serializable {

    private static final long serialVersionUID = -3374603676632608519L;

    @ApiModelProperty("预约事件id")
    private Integer id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户电话")
    private String phone;

    @ApiModelProperty("预约的日期,格式:2020-5-5")
    private String day;

    @ApiModelProperty("预约时间范围")
    private String timeRange;

    @ApiModelProperty("预约内容")
    private String content;

    @ApiModelProperty("0管理员还未阅读,1代表同意,2代表拒绝")
    private Integer status;
}
