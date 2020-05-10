package com.applet.bean.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gsj
 */

@ApiModel("留言实体类")
@Data
public class Comment implements Serializable {

    private static final long serialVersionUID = 2358555332170564580L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("留言id")
    private Integer id;

    @ApiModelProperty("留言标题")
    private String title;

    @ApiModelProperty("留言内容")
    private String content;

    @ApiModelProperty("留言类型")
    private String type;

    @ApiModelProperty("是否匿名")
    private Integer isAnonymous;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("留言日期")
    private Date day;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("被哪个管理员办理,默认为0")
    private Integer adminId;

    @ApiModelProperty("0:未接件,1:办理中,2:已办理")
    private Integer status;

    @ApiModelProperty("小区id")
    private Integer communityId;
}
