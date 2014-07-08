package com.changhong.bd.quartz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.changhong.bd.quartz.service.api.QuartzTaskService;

/**
 * @author QiYao
 * @date 2014年7月8日
 * @email yao.qi@changhong.com
 * @description 任务引擎线程对象
 *
 */
public class JobEngineRunner extends Thread {

	private static Logger logger = LoggerFactory
			.getLogger(JobEngineRunner.class);

	private QuartzTaskService quartzTaskService;

	public JobEngineRunner(QuartzTaskService quartzTaskService) {
		this.quartzTaskService = quartzTaskService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		logger.info("15秒后 调度系统启动：");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("调度系统开始启动：");

		this.quartzTaskService.init();
		

	}

}
