package com.changhong.bd.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsEntity;

/**
 * @author QiYao
 * @date 2014年7月9日
 * @email yao.qi@changhong.com
 * @description 库存
 *
 */
@Entity
@Table(name="product_inventory")
public class ProductInventory extends AbsEntity{

	private static final long serialVersionUID = -1958875193697248532L;

	@Column(name="count")
	private Double count;//库存量
	
	@Column(name="storageid")
	private ProductStorage storage;//仓库
	
	@Column(name="productid")
	private ProductBusiness product;//商品

	/**
	 * @return the count
	 */
	public Double getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Double count) {
		this.count = count;
	}

	/**
	 * @return the storage
	 */
	public ProductStorage getStorage() {
		return storage;
	}

	/**
	 * @param storage the storage to set
	 */
	public void setStorage(ProductStorage storage) {
		this.storage = storage;
	}

	/**
	 * @return the product
	 */
	public ProductBusiness getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductBusiness product) {
		this.product = product;
	}
	
	
}
