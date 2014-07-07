package com.changhong.bd.quartz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 存储调度任务
 */
@Entity
@Table(name="quartz_task")
public class QuartzTask extends AbsTxNameEntity{

	private static final long serialVersionUID = 4252237117215746312L;

	//任务类型
	@Column(name="tasktype")
	private String taskType = "";
	
	//任务实现类
	@Column(name="implclass")
	private String implClass = "";
	
	//调度策略
	@Column(name="taskexpress")
	private String taskExpress = "";
	
	//调度开始时间
	@Column(name="startdate")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startDate = new DateTime();
	
	//参数
	@Column(name="params")
	private String params = "";
	
	//创建人账户
	@Column(name="userid")
	private String userId = "";
	
	//创建人名字
	@Column(name="username")
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
