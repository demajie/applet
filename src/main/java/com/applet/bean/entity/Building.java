package com.applet.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Building)实体类
 *
 * @author LuckyCurve
 * @since 2020-05-05 09:42:54
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("楼栋实体类")
public class Building implements Serializable {
    private static final long serialVersionUID = -35826632202373948L;
    /**
    * 楼栋id
    */
    @ApiModelProperty("楼栋id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 楼栋号/楼栋名称
    */
    @ApiModelProperty("楼栋号/楼栋名称")
    private String name;
    /**
    * 从属社区
    */
    @ApiModelProperty("从属社区")
    private Integer communityId;
}