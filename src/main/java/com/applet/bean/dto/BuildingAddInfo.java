package com.applet.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author LuckyCurve
 * @date 2020/5/6 14:51
 */
public class BuildingAddInfo implements Serializable {
    private static final long serialVersionUID = -863832446074333287L;

    @ApiModelProperty("楼栋号/楼栋名称")
    private String name;

    @ApiModelProperty("从属单元个数")
    private Integer num;
}
