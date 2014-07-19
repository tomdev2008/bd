package com.changhong.bd.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月15日
 * @version 1.0
 * @description : 商品基本库信息
 */
@Entity
@Table(name="product")
public class Product extends AbsTxNameEntity{

	private static final long serialVersionUID = -8761936127669640029L;

	//计量单位
	@Column(name="measureunit")
	private String measureUnit = "斤";
}
