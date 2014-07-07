package com.changhong.bd.quartz.domain;

import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsEntity;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public class QuartzTaskLogDto extends AbsEntity{

	private static final long serialVersionUID = -7030603360382459602L;

	//任务ID
	private String taskId;
	
	//调度转读
	private String state;

	//开始时间
	private DateTime startDate;

	//结束时间
	private DateTime endDate;
	
	//调度结果
	private String result;

	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the startDate
	 */
	public DateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public DateTime getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}


}
