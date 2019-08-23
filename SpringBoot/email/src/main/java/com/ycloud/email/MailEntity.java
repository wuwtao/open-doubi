package com.ycloud.email;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 邮件信息实体
 *
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@Data
public class MailEntity {

    //收件人
    private String to;

    //标题
    private String subject;

    //正文
    private String text;

    //是否html邮件
    private boolean isHtml = false;

    //附件地址
    private List<String> files;

    //发送时间
    private Date sentDate;

}
