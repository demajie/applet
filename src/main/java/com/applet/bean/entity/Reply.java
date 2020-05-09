package com.applet.bean.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gsj
 */

@ApiModel("留言回复实体类")
@Data
public class Reply implements Serializable {
    private static final long serialVersionUID = -7503200508536512365L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("回复id")
    private Integer id;

    @ApiModelProperty("1:在处理时的回复,2:处理完时的回复")
    private Integer status;

    @ApiModelProperty("回复内容")
    private String content;

    @ApiModelProperty("回复时间")
    private Date day;

    @ApiModelProperty("回复的留言的id")
    private Integer commentId;
}
