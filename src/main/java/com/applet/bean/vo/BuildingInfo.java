package com.applet.bean.vo;

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
 * @author LuckyCurve
 * @date 2020/5/8 9:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("楼栋信息")
public class BuildingInfo implements Serializable {
    private static final long serialVersionUID = 7940700649228413455L;

    @ApiModelProperty("楼栋id")
    private Integer id;

    @ApiModelProperty("楼栋号/楼栋名称")
    private String name;
}
