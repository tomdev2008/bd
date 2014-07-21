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
@Table(name="product_business")
public class ProductBusiness extends AbsTxNameEntity{

	private static final long serialVersionUID = 2002429574485444291L;

	//缩略图地址
	@Column(name="thumbnailurl")
	private String thumbnailUrl = "";
	
	//计量单位
	@Column(name="productid")
	private String productId = "";
	
	//单位
	@Column(name="measureunit")
	private String measureUnit = "斤";
	
	//简单分类ID
	@Column(name="typeid")
	private String typeId = null;
	
	//价格
	@Column(name="price")
	private Double price = 0.0;
	
	//html显示内容
	@Column(name="htmlcontent")
	private String htmlContent;

	//是否热销
	@Column(name="ishot")
	private Integer isHot = 0;
	
	//拼音
	@Column(name="pinyin")
	private String pinyin = "";
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

	/**
	 * @return the pinyin
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * @param pinyin the pinyin to set
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * @return the measureUnit
	 */
	public String getMeasureUnit() {
		return measureUnit;
	}

	/**
	 * @param measureUnit the measureUnit to set
	 */
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the thumbnailUrl
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	/**
	 * @param thumbnailUrl the thumbnailUrl to set
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	
	
}
