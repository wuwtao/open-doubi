package com.boot.quartz.controller;

import com.boot.quartz.core.QuartzService;
import com.boot.quartz.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@RestController
@RequestMapping("/quartz/")
@Api(description = "* Quartz任务管理中心", value = "job服务")
public class JobApiController {

    private final Logger logger = LoggerFactory.getLogger(JobApiController.class);

    @Autowired
    private QuartzService quartzService;

    @Autowired
    private JobService jobService;

    @Value("${job.default.group}")
    private String JOB_DEFAULT_GROUP;

    @ApiOperation(value = "* 获取所有JOB" )
    @GetMapping("/getAllJob")
    public List<Map<String, Object>> getAllJob() {
        return quartzService.queryAllJob();
    }

    @ApiOperation(value = "* 获取所有正在运行的JOB")
    @GetMapping("/queryRunJob")
    public List<Map<String, Object>> queryRunJob() {
        return quartzService.queryRunJob();
    }

    @ApiOperation(value = "* 立即运行一个JOB")
    @PostMapping("/runJob")
    public String getJobByName(
            @RequestParam(name = "JOB_NAME", required = true) String jobName
            //@RequestParam(name = "JOB_GROUP" , required =  false) String jobGroup
    ) {
        /*if(StringHelper.isNullOrEmptyString(jobGroup)){
            jobGroup = JOB_DEFAULT_GROUP;
        }*/
        quartzService.runAJobNow(jobName, JOB_DEFAULT_GROUP);
        logger.info("run job success jobName={}", jobName);
        return "SUCCESS!!";
    }

    @ApiOperation(value = "* 暂停一个JOB")
    @PostMapping("/pauseJob")
    public String pauseJob(
            @RequestParam(name = "JOB_NAME", required = true) String jobName
            //@RequestParam(name = "JOB_GROUP" , required =  false) String jobGroup
    ) {
        /*if(StringHelper.isNullOrEmptyString(jobGroup)){
            jobGroup = JOB_DEFAULT_GROUP;
        }*/
        quartzService.pauseJob(jobName, JOB_DEFAULT_GROUP);
        logger.info("pause job success jobName={}", jobName);
        return "SUCCESS!!";
    }


    @ApiOperation(value = "* 恢复一个JOB")
    @PostMapping("/resumeJob")
    public String resumeJob(
            @RequestParam(name = "JOB_NAME", required = true) String jobName
            //@RequestParam(name = "JOB_GROUP" , required =  false) String jobGroup
    ) {
        /*if(StringHelper.isNullOrEmptyString(jobGroup)){
            jobGroup = JOB_DEFAULT_GROUP;
        }*/
        quartzService.pauseJob(jobName, JOB_DEFAULT_GROUP);
        logger.info("resume job success jobName={}", jobName);
        return "SUCCESS!!";
    }

    @ApiOperation(value = "* 删除一个JOB")
    @PostMapping("/deleteJob")
    public String deleteJob(
            @RequestParam(name = "JOB_NAME", required = true) String jobName
            //@RequestParam(name = "JOB_GROUP" , required =  false) String jobGroup
    ) {
        /*if(StringHelper.isNullOrEmptyString(jobGroup)){
            jobGroup = JOB_DEFAULT_GROUP;
        }*/
        quartzService.deleteJob(jobName, JOB_DEFAULT_GROUP);
        logger.info("delete job success jobName={}", jobName);
        return "SUCCESS!!";
    }


    @ApiOperation(value = "* 删除所有Job")
    @PostMapping("/deleteJobAll")
    public String deleteJobAll() {
        jobService.deleteAlljob();
        logger.info("delete job all success");
        return "SUCCESS!!";
    }

    @ApiOperation(value = "* 重新加载所有Job")
    @PostMapping("/init")
    public String init() {
        jobService.deleteAlljob();
        jobService.initJob();
        logger.info("init job all success");
        return "SUCCESS!!";
    }
}
