package com.applet.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LuckyCurve
 * @date 2020/5/5 15:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 5863554955036835227L;

    @ApiModelProperty("是否登录过，0未登录 1已登录")
    private Integer isLogin;

    @ApiModelProperty("权限级别，可取值：普通用户，管理员，超级管理员")
    private String level;
}
