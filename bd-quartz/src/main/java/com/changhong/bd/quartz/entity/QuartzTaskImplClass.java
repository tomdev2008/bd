package com.changhong.bd.quartz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.entity.abs.AbsEntity;

/**
 * @author QiYao
 * @date 2014年7月10日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Entity
@Table(name="quartz_task_impl_class")
public class QuartzTaskImplClass extends AbsEntity{

	private static final long serialVersionUID = -200483568810152502L;

	//实现类
	@Column(name="implclass")
	private String implClass = "";
	
	//添加用户
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="accountid", updatable=false)
	private SysAccountEntity account = null;//添加用户
	
	//添加日期
	@Column(name="adddate")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime addDate = new DateTime();

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
	 * @return the account
	 */
	public SysAccountEntity getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SysAccountEntity account) {
		this.account = account;
	}

	/**
	 * @return the addDate
	 */
	public DateTime getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate the addDate to set
	 */
	public void setAddDate(DateTime addDate) {
		this.addDate = addDate;
	}
	
	
	
}
