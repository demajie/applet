package com.applet.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("管理员简单信息")
@Data
public class AdminSimpleInfo implements Serializable {
    private static final long serialVersionUID = -7537647795072348898L;

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("政治面貌")
    private String politic;

    @ApiModelProperty("值守范围")
    private String jobDuty;
}
