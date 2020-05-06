package com.applet.utils;


import java.util.Random;

/**
 *  生成验证码工具类
 * @author gsj
 */
public class VerificationCodeUtils {

    /**
     *  生成6位小区邀请码,如果已经存在,则重新生成
     *  待完善:检验是否存在
     */
    public static String createInvitationCode() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

}
