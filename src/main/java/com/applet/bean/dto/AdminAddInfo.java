package com.applet.bean.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("管理员添加信息")
@Data
public class AdminAddInfo {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("政治面貌")
    private String politic;

    @ApiModelProperty("办公地点")
    private String office_location;

    @ApiModelProperty("固定电话")
    private String fixed_phone;
}
