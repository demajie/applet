package com.applet.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gsj
 */
@ApiModel("管理员详细信息")
@Data
public class AdminDetailInfo implements Serializable{
    private static final long serialVersionUID = 8301917223341071071L;

    @ApiModelProperty("管理员id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("政治面貌")
    private String politic;

    @ApiModelProperty("值守范围")
    private String jobDuty;

    @ApiModelProperty("办公地点")
    private String officeLocation;

    @ApiModelProperty("固定电话")
    private String fixedPhone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("工作状态:0在岗,1出勤,2节假日")
    private Integer state;

    @ApiModelProperty("用户是否开启了该管理员的返回提醒,1代表开启")
    private Integer isRelationed;
}
