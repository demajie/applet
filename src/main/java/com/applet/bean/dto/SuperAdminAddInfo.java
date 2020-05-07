package com.applet.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author LuckyCurve
 * @date 2020/5/7 14:20
 */
@ApiModel("超级管理员信息登记")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdminAddInfo implements Serializable {
    private static final long serialVersionUID = -211609935661169265L;

    @ApiModelProperty("用户appId")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("出生日期")
    private LocalDateTime birthday;

    @ApiModelProperty("用户邮箱")
    private String email;
}
