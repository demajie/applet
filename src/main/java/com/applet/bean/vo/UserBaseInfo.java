package com.applet.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LuckyCurve
 * @date 2020/6/10 21:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("用户基本信息")
public class UserBaseInfo {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户住址")
    private String address;
}
