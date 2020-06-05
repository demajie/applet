package com.applet.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LuckyCurve
 * @date 2020/6/1 11:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("筛选条件")
public class AnnoConditionInfo implements Serializable {

    private static final long serialVersionUID = -3856628162644885988L;

    @ApiModelProperty("楼栋id")
    private Integer buildingId;

    @ApiModelProperty("年龄下限")
    private Integer minAge;

    @ApiModelProperty("年龄上限")
    private Integer maxAge;

    @ApiModelProperty("性别，取值：男、女、不限")
    private String gender;

    @ApiModelProperty("人口下限")
    private Integer minNum;

    @ApiModelProperty("人口上限")
    private Integer maxNum;

    @ApiModelProperty("通知家人")
    private Boolean bool;

    @ApiModelProperty("消息级别")
    private String level;

    @ApiModelProperty("消息头部")
    private String title;
    
    @ApiModelProperty("消息内容")
    private String message;
}
