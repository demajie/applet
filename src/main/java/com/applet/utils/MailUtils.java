package com.applet.utils;

import com.applet.mapper.UserMapper;
import com.applet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.server.RSocketServer;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


    static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        MailUtils.userService = userService;
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

    /**
     *  群发邮件
     */
    public static void sendMails(List<Integer> ids,String adminName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("您设置了返回提醒的管理员:"+adminName + " 状态已变为在岗");
        message.setSubject("您关注的管理员上班了");
        message.setFrom(from);

        for (int i = 0; i < ids.size(); i++) {
            final int id = ids.get(i);
            message.setTo(userService.getById(ids.get(i)).getEmail());
            sender.send(message);
        }


    }



}

