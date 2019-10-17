package com.spring.boot.mybatis.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@Data
@ToString
public class Pager {
    /*当前页*/
    private int page;
    /*每页大小*/
    private int size;
    /*总记录*/
    private long total;
    /*总页数*/
    private int totalPage;
    /*自定义分页sql*/
    private String customSQL;
    /*分页执行时长*/
    private long executeTime;
}
