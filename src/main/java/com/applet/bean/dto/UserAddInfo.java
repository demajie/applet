package com.applet.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author LuckyCurve
 * @date 2020/5/5 15:39
 */
@ApiModel("用户信息收集模块")
public class UserAddInfo implements Serializable {

    private static final long serialVersionUID = 7436514132682712643L;

    @ApiModelProperty("用户的appid，前端手动获取")
    private Integer appId;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("出生日期")
    private LocalDateTime birthday;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("社区邀请码")
    private Integer communityId;

    @ApiModelProperty("楼栋id，可以通过获取所有楼栋信息方法来绑定")
    private Integer buildingId;

    @ApiModelProperty("单元id，可以通过获取当前楼栋所有单元信息方法来绑定")
    private Integer unitId;

    @ApiModelProperty("门牌号")
    private String houseNum;
}
