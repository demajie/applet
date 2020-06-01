package com.applet.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author LuckyCurve
 * @date 2020/6/1 11:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageUser implements Serializable {

    private static final long serialVersionUID = -2200755777891530149L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String message;

    private String userList;

    private LocalDateTime annoTime;

    private String level;

    private Integer annoUser;
}
