package com.changhong.bd.quartz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.joda.time.DateTime;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.utils.PageUtils;
import com.changhong.bd.quartz.dao.api.QuartzTaskDao;
import com.changhong.bd.quartz.domain.QuartzTaskDto;
import com.changhong.bd.quartz.entity.QuartzTask;
import com.changhong.bd.quartz.service.api.QuartzTaskService;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Service("QuartzTaskService")
@Transactional(readOnly=true)
public class QuartzTaskServiceImpl implements QuartzTaskService{

	private Logger logger = LoggerFactory.getLogger(QuartzTaskServiceImpl.class);
	
	private Scheduler inScheduler = null;
	
	@Autowired
	private QuartzTaskDao quartzTaskDao;
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskService#query(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public JsonPageData<QuartzTask> query(Integer pageNo, Integer pageSize,
			DateTime startTime) {
		DetachedCriteria dc = this.quartzTaskDao.createDetachedCriteria();
		DetachedCriteria cdc = this.quartzTaskDao.createDetachedCriteria();
		
		if(null!=startTime){
			SimpleExpression se = Restrictions.lt("startDate", startTime);
			dc.add(se);
			cdc.add(se);
		}
		
		Long count = this.quartzTaskDao.queryRowCount(cdc);
		List<QuartzTask> list = null;
		
		if(null!=pageNo && null!=pageSize){
			Integer ps[] = PageUtils.page(pageNo, pageSize);
			list = this.quartzTaskDao.queryByCriteria(dc, ps[0], pageSize);
		}else{
			list = this.quartzTaskDao.queryByCriteria(dc);
		}
		
		JsonPageData<QuartzTask> jpd = new JsonPageData<QuartzTask>(pageNo, pageSize, count, list);
		return jpd;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskService#add(com.changhong.bd.quartz.entity.QuartzTask)
	 */
	@Override
	@Transactional(readOnly=false)
	public QuartzTaskDto add(QuartzTask e) {
		QuartzTaskDto dto = new QuartzTaskDto();
		e = this.quartzTaskDao.save(e);
		BeanUtils.copyProperties(e, dto);
		
		
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskService#delete(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(String id) {
		QuartzTask task = this.quartzTaskDao.query(id);
		if(null!=task && null!=inScheduler){
			try {
				TriggerKey triggerKey = new TriggerKey(task.getId(), task.getId());
				this.inScheduler.unscheduleJob(triggerKey );
				JobKey jobKey = new JobKey(task.getId(), task.getId());
				this.inScheduler.deleteJob(jobKey );
			} catch (SchedulerException e) {
				e.printStackTrace();
				logger.error("移除任务{}:{}失败，任务将在下一次重启的时候失效。",task.getId(),task.getImplClass());
			}
		}
		this.quartzTaskDao.delete(task);
	}

	@Override
	public void init() {
		try {
			inScheduler = StdSchedulerFactory.getDefaultScheduler();

			JsonPageData<QuartzTask> jpd = this.query(null, null,
					new DateTime());
			if (jpd.getCount() > 0) {
				List<QuartzTask> list = jpd.getDatas();
				for (QuartzTask qt : list) {
					try {
						this.addJob(qt);
					} catch (ClassNotFoundException e) {
						logger.error("任务ID：{}, 没有找到任务类：{}",qt.getId(),qt.getImplClass());
					}

				}
			}
			inScheduler.start();
		} catch (SchedulerException e) {
			logger.error("获取调度任务中心失败！");
		}
	}

	@SuppressWarnings("unchecked")
	private void addJob(QuartzTask qt) throws ClassNotFoundException, SchedulerException{

		Map<String, String> map = new HashMap<String, String>();
		map.put("params", qt.getParams());
		map.put("taskId", qt.getId());
		map.put("implClass", qt.getImplClass());
		map.put("name", qt.getName());
		map.put("taskExpress", qt.getTaskExpress());

		JobDataMap data = new JobDataMap(map);
		JobDetail job = null;

		CronTrigger trigger = null;
		job = JobBuilder
				.newJob((Class<? extends Job>) Class.forName(qt
						.getImplClass()))
				.withIdentity(qt.getId(), qt.getId()).setJobData(data)
				.build();
		trigger = TriggerBuilder
				.newTrigger()
				.withSchedule(
						CronScheduleBuilder.cronSchedule(qt
								.getTaskExpress())).build();

		inScheduler.scheduleJob(job, trigger);
	}
	
	//TODO
	@SuppressWarnings("unused")
	private void updateJob(QuartzTask qt) throws SchedulerException{
		TriggerKey triggerKey = new TriggerKey(qt.getId(),qt.getId());
		inScheduler.unscheduleJob(triggerKey );
		JobKey jobKey = new JobKey(qt.getId(), qt.getId());
		inScheduler.deleteJob(jobKey );
	}
}
