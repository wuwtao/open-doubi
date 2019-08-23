package com.ycloud.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping("send")
    public void test() {
        MailEntity emailContextPojo = new MailEntity();
        emailContextPojo.setSubject("Ycloud架构平台邮箱分发并发能力测试");
        emailContextPojo.setText("Ycloud架构平台邮箱分发并发能力测试");
        emailContextPojo.setTo("1106734690@qq.com");
        emailContextPojo.setFiles(Arrays.asList("D:\\Yum系统架构平台\\004.高系统部署\\004.PXC\\部署方式.txt"));
//        emailHelper.sendMail(emailContextPojo);
//
//        emailContextPojo.setHtml(true);
//        emailHelper.sendMail(emailContextPojo);
        //MailHelper.buidler().sendMail(emailContextPojo);

        List<MailEntity> mailEntities = new ArrayList<>();
        mailEntities.add(emailContextPojo);


        MailEntity emailContextPojo2 = new MailEntity();
        emailContextPojo2.setSubject("Ycloud架构平台邮箱分发并发能力测试");
        emailContextPojo2.setText("Ycloud架构平台邮箱分发并发能力测试");
        emailContextPojo2.setTo("450255266@qq.com");
        emailContextPojo2.setFiles(Arrays.asList("D:\\Yum系统架构平台\\004.高系统部署\\004.PXC\\部署方式.txt"));

        mailEntities.add(emailContextPojo2);

        MailEntity[] mailEntitiArray = new MailEntity[mailEntities.size()];
        mailEntities.toArray(mailEntitiArray);
        MailHelper.buidler().sendMail(mailEntitiArray);
    }

}
