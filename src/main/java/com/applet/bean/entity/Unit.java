package com.applet.bean.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Unit)实体类
 *
 * @author LuckyCurve
 * @since 2020-05-05 09:43:01
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("单元实体类")
public class Unit implements Serializable {
    private static final long serialVersionUID = -82063532051438293L;
    /**
    * 单元id
    */
    @ApiModelProperty("单元id")
    private Integer id;
    /**
    * 单元号/单元名称
    */
    @ApiModelProperty("单元号/单元名称")
    private String name;
    /**
    * 从属楼栋
    */
    @ApiModelProperty("从属楼栋")
    private Integer buildingId;
}