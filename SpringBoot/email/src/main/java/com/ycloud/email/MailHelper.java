package com.ycloud.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 邮箱发送工具类
 *
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@Component
@Slf4j
public class MailHelper {


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    private static MailHelper mailHelper;

    public MailHelper() {
        mailHelper = this;
    }

    /**
     * 构建静态获取实例
     *
     * @return
     */
    public static MailHelper buidler() {
        if (mailHelper == null) {
            return null;
        }
        return mailHelper;
    }

    /*public void sendSimpleMail(EmailContextPojo mailBean) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(emailSender);
            //邮件接收人
            simpleMailMessage.setTo(mailBean.getTo());
            //邮件主题
            simpleMailMessage.setSubject(mailBean.getSubject());
            //邮件内容
            simpleMailMessage.setText(mailBean.getText());
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("邮件发送失败", e.getMessage());
        }
    }*/


    public void sendMail(MailEntity mailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = MailEntityHelper.craeteMessageHelper(mimeMailMessage, mailBean);
            mimeMessageHelper.setFrom(emailSender);//发件人
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败", e.getMessage());
        }
    }


    public void sendMail(MailEntity... mailBeans) {
        //批量发送集合
        List<MimeMessage> mimeMessages = new ArrayList<>(mailBeans.length);
        try {
            if (mailBeans != null || mailBeans.length > 0) {
                for (int i = 0; i < mailBeans.length; i++) {
                    MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
                    MimeMessageHelper messageHelper = MailEntityHelper.craeteMessageHelper(mimeMailMessage, mailBeans[i]);
                    messageHelper.setFrom(emailSender);//发件人
                    mimeMessages.add(mimeMailMessage);
                }
            }

            MimeMessage[] resultMessage = new MimeMessage[mimeMessages.size()];
            mimeMessages.toArray(resultMessage);
            javaMailSender.send((resultMessage));
        } catch (Exception e) {
            log.error("邮件发送失败", e.getMessage());
        }
    }


}
