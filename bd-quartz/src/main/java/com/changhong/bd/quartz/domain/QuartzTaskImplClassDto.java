package com.changhong.bd.quartz.domain;

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
public class QuartzTaskImplClassDto extends AbsEntity{

	private static final long serialVersionUID = 1136014063087675674L;
	private String implClass = "";
	
	//添加用户
	private SysAccountEntity account = null;//添加用户
	
	//添加日期
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
