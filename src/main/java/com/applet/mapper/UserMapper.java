package com.applet.mapper;

import com.applet.bean.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LuckyCurve
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT COUNT(*) FROM user WHERE house_num = #{house}")
    Integer countByHouse(String house);
}
