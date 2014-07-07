package com.changhong.bd.quartz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.quartz.entity.QuartzTask;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@SuppressWarnings("unchecked")
	public void execute() throws SchedulerException,
			ClassNotFoundException {
		logger.info("jobEngine execute");

		Scheduler inScheduler = StdSchedulerFactory.getDefaultScheduler();

		JobDetail job = null;

		CronTrigger trigger = null;

		JsonPageData<QuartzTask> jpd = this.quartzTaskService.query(null, null,
				new DateTime());
		if (jpd.getCount() > 0) {
			List<QuartzTask> list = jpd.getDatas();
			for (QuartzTask qt : list) {
				Map<String, String> map = new HashMap<String,String>();
				map.put("params", qt.getParams());
				
				JobDataMap data = new JobDataMap(map);
				job = JobBuilder
						.newJob((Class<? extends Job>) Class.forName(qt
								.getImplClass()))
						.withIdentity(qt.getId(), qt.getId())
						.setJobData(data).build();

				trigger = TriggerBuilder
						.newTrigger()
						.withSchedule(
								CronScheduleBuilder.cronSchedule(qt
										.getTaskExpress())).build();

				inScheduler.scheduleJob(job, trigger);

			}
		}
		inScheduler.start();
	}

}
