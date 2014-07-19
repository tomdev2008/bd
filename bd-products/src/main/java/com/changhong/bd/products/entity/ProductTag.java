package com.changhong.bd.products.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月19日
 * @email yao.qi@changhong.com
 * @description 商品标签 
 *
 */
@Entity
@Table(name="product_tag")
public class ProductTag extends AbsTxNameEntity{

	private static final long serialVersionUID = -7000318854994723171L;
}
