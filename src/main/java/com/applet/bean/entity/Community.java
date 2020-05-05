package com.applet.bean.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Community)实体类
 *
 * @author LuckyCurve
 * @since 2020-05-05 09:42:48
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("社区实体类")
public class Community implements Serializable {
    private static final long serialVersionUID = -93385308685272535L;
    /**
    * 社区id
    */
    @ApiModelProperty("社区id")
    private Integer id;
    /**
    * 社区名称
    */
    @ApiModelProperty("社区名称")
    private String name;
}