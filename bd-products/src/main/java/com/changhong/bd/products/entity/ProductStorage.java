package com.changhong.bd.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月9日
 * @email yao.qi@changhong.com
 * @description 商品仓库 
 * 
 */
@Entity
@Table(name="product_storage")
public class ProductStorage extends AbsTxNameEntity{

	private static final long serialVersionUID = -1478717487235391373L;
	
	/**
	 * 仓库所在位置
	 */
	@Column(name="location")
	private String location = "";

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	
	
}
