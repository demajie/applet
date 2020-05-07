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
 * @date 2020/5/6 14:51
 */
@ApiModel("楼栋创建")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildingAddInfo implements Serializable {
    private static final long serialVersionUID = -863832446074333287L;

    @ApiModelProperty("楼栋号/楼栋名称")
    private String name;

    @ApiModelProperty("从属单元个数")
    private Integer num;
}
