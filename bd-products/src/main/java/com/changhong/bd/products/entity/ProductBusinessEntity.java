package com.changhong.bd.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 销售商品信息
 */
@Entity
@Table(name="")
public class ProductBusinessEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 2002429574485444291L;

	//计量单位
	@Column(name="productid")
	private ProductEntity product;

	//价格
	@Column(name="price")
	private Double price;
	
	
}
