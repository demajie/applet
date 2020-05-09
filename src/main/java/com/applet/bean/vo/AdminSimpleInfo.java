package com.applet.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gsj
 */
@ApiModel("管理员简单信息")
@Data
public class AdminSimpleInfo implements Serializable {
    private static final long serialVersionUID = -7537647795072348898L;

    @ApiModelProperty("管理员id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("政治面貌")
    private String politic;

    @ApiModelProperty("值守范围")
    private String jobDuty;

    @ApiModelProperty("工作状态:0在岗,1出勤,2节假日")
    private Integer state;

    @ApiModelProperty("管理员照片")
    private String photo;
}
