package com.applet.bean.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel("用户实体类")
@Data
public class User {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别,0男1女")
    private Integer gender;

    @ApiModelProperty("出生日期")
    private LocalDateTime birthday;

    @ApiModelProperty("用户权限等级,0普通用户,1普通管理员,2超级管理员")
    private Integer permId;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("社区id")
    private Integer communityId;

    @ApiModelProperty("楼栋id")
    private Integer buildingId;

    @ApiModelProperty("单元id")
    private Integer unitId;
}
