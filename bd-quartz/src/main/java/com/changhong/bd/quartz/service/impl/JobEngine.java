package com.changhong.bd.quartz.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.changhong.bd.quartz.service.api.QuartzTaskService;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 任务调度引擎，负责装载任务，进行任务调度
 *
 */
@Component
public class JobEngine {

	@Autowired
	private QuartzTaskService quartzTaskService;

	private static Logger logger = LoggerFactory.getLogger(JobEngine.class);

	@PostConstruct
	public void after(){
		logger.info("jobEngine post:");
		JobEngineRunner jer = new JobEngineRunner(quartzTaskService);
		jer.start();
	}

}
