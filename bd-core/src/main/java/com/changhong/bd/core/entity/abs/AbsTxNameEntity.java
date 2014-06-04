package com.changhong.bd.core.entity.abs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 带名称/乐观锁/状态 实体
 */
@MappedSuperclass
public abstract class AbsTxNameEntity extends AbsTxEntity{

	private static final long serialVersionUID = 207680737456858089L;

	public AbsTxNameEntity(){
		
	}
	public AbsTxNameEntity(AbsTxNameEntity tx){
		super(tx);
		this.name = tx.getName();
	}
	//名称
	@Column(name="name", length=128)
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
