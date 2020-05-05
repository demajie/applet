package com.applet.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 *  邮箱工具类
 */
@Component
public class MailUtils {

    private static String from = "541099558@qq.com";

    private static MailSender sender;

    @Autowired
    public void setSender(MailSender sender) {
        MailUtils.sender = sender;
    }

    /**
     * @param to 收件人邮箱
     * @param title 主题
     * @param content 内容(暂时只支持文本内容)
     */
    public static void sendMail(String to,String title,String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(content);
        message.setSubject(title);
        message.setFrom(from);
        message.setTo(to);
        sender.send(message);
    }
}
