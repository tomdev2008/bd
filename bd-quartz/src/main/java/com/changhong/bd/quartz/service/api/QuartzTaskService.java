package com.changhong.bd.quartz.service.api;

import org.joda.time.DateTime;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.quartz.domain.QuartzTaskDto;
import com.changhong.bd.quartz.entity.QuartzTask;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 任务服务
 *
 */
public interface QuartzTaskService {

	/**
	 * 查询任务
	 * @param pageNo
	 * @param pageSize
	 * @param startTime
	 * @return
	 */
	public JsonPageData<QuartzTask> query(
			Integer pageNo,
			Integer pageSize,
			DateTime startTime
			);

	/**
	 * 新增任务
	 * @param e
	 * @return
	 */
	public QuartzTaskDto add(QuartzTask e);
	
	/**
	 * 删除一个任务
	 * @param id
	 */
	public void delete(String id);

	/**
	 * 初始化任务调度系统
	 */
	public void init();
}
