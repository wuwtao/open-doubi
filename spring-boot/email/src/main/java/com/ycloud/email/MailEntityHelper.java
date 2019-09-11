package com.ycloud.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 邮箱发送信息封装
 *
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@Slf4j
public class MailEntityHelper {


    public static MimeMessageHelper craeteMessageHelper(MimeMessage mimeMessage, MailEntity mailBean) throws MessagingException {

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        // mimeMessageHelper.setFrom(emailSender);//发件人
        mimeMessageHelper.setTo(mailBean.getTo());//收件人
        mimeMessageHelper.setSubject(mailBean.getSubject());//标题
        mimeMessageHelper.setText(mailBean.getText(), mailBean.isHtml());//是否html
        mimeMessageHelper.setSentDate(mailBean.getSentDate() == null ? new Date() : mailBean.getSentDate());
        if (mailBean.getFiles() != null && mailBean.getFiles().size() > 0) {
            //附件添加
            mailBean.getFiles().forEach(filename -> {
                String ext = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
                File diskfile = new File(filename);
                try {
                    mimeMessageHelper.addAttachment(diskfile.getName(), diskfile);
                } catch (MessagingException e) {
                    e.printStackTrace();
                    log.error("设置附件失败:{}", mailBean);
                }
            });
        }
        return mimeMessageHelper;
    }

}
