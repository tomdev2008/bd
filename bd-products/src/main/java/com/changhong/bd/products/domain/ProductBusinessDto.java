package com.changhong.bd.products.domain;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public class ProductBusinessDto extends AbsTxNameEntity{

	private static final long serialVersionUID = 2002429574485444291L;

	//计量单位
	private String productId = "";

	//价格
	private Double price = 0.0;
	
	//html显示内容
	private String htmlContent;

	//是否热销
	private Integer isHot = 0;

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
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

	/**
	 * @return the htmlContent
	 */
	public String getHtmlContent() {
		return htmlContent;
	}

	/**
	 * @param htmlContent the htmlContent to set
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	/**
	 * @return the isHot
	 */
	public Integer getIsHot() {
		return isHot;
	}

	/**
	 * @param isHot the isHot to set
	 */
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	
	
}
