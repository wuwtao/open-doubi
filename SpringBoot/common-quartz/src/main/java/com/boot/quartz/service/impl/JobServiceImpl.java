package com.boot.quartz.service.impl;

import com.boot.quartz.core.QuartzService;
import com.boot.quartz.dao.JobRepository;
import com.boot.quartz.entites.JobPojo;
import com.boot.quartz.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private QuartzService quartzService;

    /**
     * 初始化Job数据
     */
    @Override
    @PostConstruct
    public void initJob(){
        List<JobPojo> jobAll = jobRepository.findAll();
        jobAll.forEach(job->{
            String jobClass = job.getJobClass();
            try {
                Class clazz = Class.forName(jobClass);
                if("1".equals(job.getJobType())){
                    //CRON表达式方式
                    quartzService.addJob(clazz,job.getJobName(),job.getJobGroupName(),job.getJobTime());
                    logger.info("INIT JOB CRON JOB_NAME = " + job.getJobName());
                }else if("2".equals(job.getJobType())){
                    //秒形式
                    quartzService.addJob(clazz,job.getJobName(),job.getJobGroupName(),Integer.valueOf(job.getJobTime()),job.getJobCount());
                    logger.info("INIT JOB JOB_NAME = " + job.getJobName());
                }
            } catch (ClassNotFoundException e) {
                logger.error("JOB INIT ERROR:{}", job);
                logger.error("JOB INIT ERROR MSG:{}", e);
            }
        });
        logger.info("SYSTEM DB JOB INIT ALL SUCCESS!!!");
    }

    @Override
    public int deleteAlljob() {
        List<JobPojo> jobAll = jobRepository.findAll();
        jobAll.forEach(job->{
            quartzService.deleteJob(job.getJobName(),job.getJobGroupName());
        });
        return 1;
    }
}
