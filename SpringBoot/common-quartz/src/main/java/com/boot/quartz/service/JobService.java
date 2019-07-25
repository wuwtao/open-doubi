package com.boot.quartz.service;

public interface JobService {

    /**
     * 初始化所有Job
     */
    public void initJob();

    public int deleteAlljob();
}
