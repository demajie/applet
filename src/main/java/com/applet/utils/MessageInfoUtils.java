package com.applet.utils;

import com.applet.bean.vo.MessageInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LuckyCurve
 * @date 2020/6/1 9:43
 */
public class MessageInfoUtils {

    public static List<MessageInfo> sort(List<MessageInfo> list) {
        return list.stream().sorted((a1, a2) -> {
            char op1 = a1.getLevel().charAt(0);
            char op2 = a2.getLevel().charAt(0);
            return Character.compare(op1, op2);
        }).collect(Collectors.toList());
    }
}
