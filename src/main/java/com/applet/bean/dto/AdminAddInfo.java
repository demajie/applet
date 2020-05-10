package com.applet.bean.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;

/**
 * @author gsj
 */

@ApiModel("普通管理员添加信息")
@Data
public class AdminAddInfo implements Serializable {

    private static final long serialVersionUID = 5922699961775263714L;

    @ApiModelProperty("用户id")
    private Integer id;

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

    @ApiModelProperty("管理员照片")
    private MultipartFile file;
}
