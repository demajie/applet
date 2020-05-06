package com.applet.utils;


import java.util.Random;

/**
 *  生成验证码工具类
 * @author gsj
 */
public class VerificationCodeUtils {

    /**
     *  生成6位小区邀请码,如果已经存在,则重新生成
     */
    public static String createInvitationCode() {
        Random random = new Random();
        String invitationCode = "";
        for (int i = 0; i < 6; i++) {
            invitationCode += random.nextInt(10);
        }
        System.out.println(invitationCode);
        return invitationCode;
    }



}
