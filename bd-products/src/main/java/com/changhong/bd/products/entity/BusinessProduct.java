package com.changhong.bd.products.entity;

import javax.persistence.Column;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 销售商品信息
 */
public class BusinessProduct extends AbsTxNameEntity{

	private static final long serialVersionUID = 2002429574485444291L;

	//计量单位
	@Column(name="measureunit")
	private String measureUnit = "斤";
}
