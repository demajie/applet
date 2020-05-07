package com.applet.bean.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author LuckyCurve
 * @since 2020-05-05 09:42:10
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("消息实体类")
public class Message implements Serializable {
    private static final long serialVersionUID = -14372584819198822L;

    /**
    * 消息id
    */
    @ApiModelProperty("消息id")
    private Integer id;


    /**
    * 消息体
    */
    @ApiModelProperty("消息体")
    private String message;


    /**
    * 接收消息的小区id
    */
    @ApiModelProperty("接收消息的小区id")
    private Integer communityId;


    /**
    * 接收消息的楼栋id
    */
    @ApiModelProperty("接收消息的楼栋id")
    private Integer buildingId;


    /**
    * 接收消息的单元id
    */
    @ApiModelProperty("接收消息的单元id")
    private Integer unitId;


    /**
    * 消息发布时间
    */
    @ApiModelProperty("消息发布时间")
    private LocalDateTime annoTime;

    /**
     * 消息等级
     */
    @ApiModelProperty("消息等级")
    private String level;

    @ApiModelProperty("消息发布人id")
    private Integer annoUser;
}