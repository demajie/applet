package com.applet.bean.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LuckyCurve
 * @date 2020/5/8 9:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("单元信息")
public class UnitInfo {

    @ApiModelProperty("单元id")
    private Integer id;

    @ApiModelProperty("单元号/单元名称")
    private String name;
}
