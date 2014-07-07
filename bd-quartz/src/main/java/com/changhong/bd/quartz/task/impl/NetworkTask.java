package com.changhong.bd.quartz.task.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.changhong.bd.core.service.SpringHelper;
import com.changhong.bd.network.service.api.NetworkService;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public class NetworkTask implements Job {

	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		NetworkService networkService = SpringHelper.beanFactory.getBean("networkService", NetworkService.class);
		String url = (String)context.get("params");
		networkService.httpRequest(url, null, null);
	}

}
