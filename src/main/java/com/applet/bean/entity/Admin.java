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
 * @author gsj
 */

@ApiModel("管理员实体类")
@Data
public class Admin implements Serializable {

    private static final long serialVersionUID = -909203054937672055L;

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("值守范围")
    private String jobDuty;

    @ApiModelProperty("政治面貌")
    private String politic;

    @ApiModelProperty("办公地点")
    private String officeLocation;

    @ApiModelProperty("固定电话")
    private String fixedPhone;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("管理员照片")
    private String photo;

    @ApiModelProperty("工作状态:0在岗,1出勤,2开会")
    private Integer state;

    @ApiModelProperty("社区id")
    private Integer communityId;
}
