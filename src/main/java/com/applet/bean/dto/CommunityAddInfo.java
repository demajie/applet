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
 * @date 2020/5/6 14:37
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("创建社区信息")
public class CommunityAddInfo implements Serializable {
    private static final long serialVersionUID = 6018316808157053295L;

    @ApiModelProperty("社区名称")
    private String name;

    @ApiModelProperty("社区地址")
    private String address;

    @ApiModelProperty("用户id")
    private Integer id;
}
