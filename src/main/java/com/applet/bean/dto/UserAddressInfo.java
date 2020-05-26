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
 * @date 2020/5/26 15:28
 */
@ApiModel("用户住址信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressInfo implements Serializable {

    private static final long serialVersionUID = 8519088433719835442L;

    @ApiModelProperty("楼栋id，可以通过获取所有楼栋信息方法来绑定")
    private Integer buildingId;

    @ApiModelProperty("单元id，可以通过获取当前楼栋所有单元信息方法来绑定")
    private Integer unitId;

    @ApiModelProperty("门牌号")
    private String houseNum;
}
