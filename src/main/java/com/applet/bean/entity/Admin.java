package com.applet.bean.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("管理员实体类")
@Data
public class Admin {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("政治面貌")
    private String politic;

    @ApiModelProperty("办公地点")
    private String office_location;

    @ApiModelProperty("固定电话")
    private String fixed_phone;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户照片")
    private String photo;

    @ApiModelProperty("工作状态,0在岗,1外出")
    private Integer state;
}
