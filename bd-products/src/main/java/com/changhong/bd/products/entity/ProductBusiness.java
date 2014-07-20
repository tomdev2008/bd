package com.changhong.bd.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 销售商品信息
 */
@Entity
@Table(name="product_business")
public class ProductBusiness extends AbsTxNameEntity{

	private static final long serialVersionUID = 2002429574485444291L;

	//计量单位
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productid")
	private Product product = null;

	//价格
	@Column(name="price")
	private Double price = 0.0;

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
