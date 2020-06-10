package com.applet.bean.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gsj
 */

@Data
@ApiModel("用户开启管理员的返回提醒")
public class Relation implements Serializable {
    private static final long serialVersionUID = -355472725936651520L;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("管理员id")
    private Integer adminId;
}
