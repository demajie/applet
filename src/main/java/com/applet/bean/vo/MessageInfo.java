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
import java.time.LocalDateTime;

/**
 * @author LuckyCurve
 * @date 2020/5/5 15:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("展示的消息")
public class MessageInfo implements Serializable {
    private static final long serialVersionUID = -1024983820237141960L;

    @ApiModelProperty("消息id")
    private Integer id;

    @ApiModelProperty("消息体")
    private String message;

    @ApiModelProperty("消息发布时间")
    private LocalDateTime annoTime;

    @ApiModelProperty("消息等级")
    private String level;

    @ApiModelProperty("消息发布人名")
    private String annoUser;
}
