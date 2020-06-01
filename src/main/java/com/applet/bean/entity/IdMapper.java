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
 * @author LuckyCurve
 * @date 2020/5/17 21:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户id转换实体类")
public class IdMapper implements Serializable {

    private static final long serialVersionUID = 2700397416594638161L;
    @ApiModelProperty("用户id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户openId")
    private String openId;
}
