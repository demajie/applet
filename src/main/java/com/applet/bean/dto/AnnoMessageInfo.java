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
 * @date 2020/5/8 11:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("发布消息信息")
public class AnnoMessageInfo implements Serializable {
    private static final long serialVersionUID = -7103131094051149305L;

    @ApiModelProperty("消息体")
    private String message;

    @ApiModelProperty("消息等级，可取值：A、B、C")
    private String level;
}
