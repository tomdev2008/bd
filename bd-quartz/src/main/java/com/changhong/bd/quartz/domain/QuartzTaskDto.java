package com.changhong.bd.quartz.domain;

import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public class QuartzTaskDto extends AbsTxNameEntity{

	private static final long serialVersionUID = -543992007706654068L;

	//任务类型
	private String taskType = "";
	
	//任务实现类
	private String implClass = "";
	
	//调度策略
	private String taskExpress = "";
	
	//调度开始时间
	private DateTime startDate = new DateTime();
	
	//参数
	private String params = "";
	
	//创建人账户
	private String userId = "";
	
	//创建人名字
	private String userName = "";

	/**
	 * @return the taskType
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
	 * @return the implClass
	 */
	public String getImplClass() {
		return implClass;
	}

	/**
	 * @param implClass the implClass to set
	 */
	public void setImplClass(String implClass) {
		this.implClass = implClass;
	}

	/**
	 * @return the taskExpress
	 */
	public String getTaskExpress() {
		return taskExpress;
	}

	/**
	 * @param taskExpress the taskExpress to set
	 */
	public void setTaskExpress(String taskExpress) {
		this.taskExpress = taskExpress;
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
	 * @return the params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
