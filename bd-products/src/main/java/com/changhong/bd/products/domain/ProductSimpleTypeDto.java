package com.changhong.bd.products.domain;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public class ProductSimpleTypeDto extends AbsTxNameEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3133815266754920662L;

	private Integer priority = 1;

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
}
