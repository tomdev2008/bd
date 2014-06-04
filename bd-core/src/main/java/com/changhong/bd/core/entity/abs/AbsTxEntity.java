package com.changhong.bd.core.entity.abs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 乐观锁/ID/状态
 */
@MappedSuperclass
public abstract class AbsTxEntity extends AbsEntity{
	private static final long serialVersionUID = 7822525388868517097L;

	@Version
	@Column(name="optlock")
	private Integer optLock = 0;
	
	@Column(name="status")
	private Integer status = 1;

	public AbsTxEntity(){
		
	}
	public AbsTxEntity(AbsTxEntity e){
		super(e);
		this.optLock = e.getOptLock();
		this.status = e.getStatus();
	}
	public Integer getOptLock() {
		return optLock;
	}

	public void setOptLock(Integer optLock) {
		this.optLock = optLock;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
