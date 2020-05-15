package com.applet.bean.vo;

import com.applet.bean.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gsj
 */
@ApiModel("留言简单信息")
@Data
@ToString(exclude = "user")
public class CommentSimpleInfo implements Serializable {
    private static final long serialVersionUID = 5917225230534125971L;

    @ApiModelProperty("留言id")
    private Integer id;

    @ApiModelProperty("留言标题")
    private String title;

    @ApiModelProperty("留言内容简介")
    private String introduction;

    @ApiModelProperty("留言类型")
    private String type;

    @ApiModelProperty("留言日期")
    private String day;

    @ApiModelProperty("留言人姓+先生或女士")
    private String firstName;

    @ApiModelProperty("0:未接件,1:办理中,2:已办理")
    private Integer status;

    @ApiModelProperty(hidden = true)
    private User user;

    @ApiModelProperty("被哪个管理员办理,默认为0")
    private Integer adminId;

    @ApiModelProperty("管理员是否有权限办理,1代表有,0则不能")
    private Integer canDeal;
}
