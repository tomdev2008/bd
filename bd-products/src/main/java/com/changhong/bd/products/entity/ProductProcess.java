package com.changhong.bd.products.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月9日
 * @email yao.qi@changhong.com
 * @description 商品加工
 *
 */
@Entity
@Table(name="product_process")
public class ProductProcess extends AbsTxNameEntity{

	private static final long serialVersionUID = 8068256033152973816L;

	@ManyToOne
	@JoinColumn(name="processgroupid")
	private ProductProcessGroup processGroup = null;

	/**
	 * @return the processGroup
	 */
	public ProductProcessGroup getProcessGroup() {
		return processGroup;
	}

	/**
	 * @param processGroup the processGroup to set
	 */
	public void setProcessGroup(ProductProcessGroup processGroup) {
		this.processGroup = processGroup;
	}
	
	
	
}
