package com.changhong.bd.quartz.task.impl;

import org.joda.time.DateTime;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.changhong.bd.core.service.SpringHelper;
import com.changhong.bd.network.service.api.NetworkService;
import com.changhong.bd.quartz.entity.QuartzTaskLog;
import com.changhong.bd.quartz.service.api.QuartzTaskLogService;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public class NetworkTask implements Job {
	private static Logger logger = LoggerFactory.getLogger(NetworkTask.class);
	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("execute {} scheduler task", NetworkTask.class.getName());
		NetworkService networkService = SpringHelper.beanFactory.getBean("networkService", NetworkService.class);
		QuartzTaskLogService quartzTaskLogService = SpringHelper.beanFactory.getBean("quartzTaskLogService", QuartzTaskLogService.class);
		
		JobDataMap data = context.getMergedJobDataMap();
		String url = (String)data.get("params");
		String taskId = (String)data.get("taskId");
		String result = null;
		
		QuartzTaskLog log = new QuartzTaskLog();
		
		log.setStartDate(new DateTime(System.currentTimeMillis()));
		log.setTaskId(taskId);
		try{
			result = networkService.httpGet(url, null, null);
			log.setResult(result);
			log.setState("c");
		}catch(Exception e){
			log.setState("e");
		}finally{
			log.setEndDate(new DateTime(System.currentTimeMillis()));
		}
		
		quartzTaskLogService.add(log );
	}

}
