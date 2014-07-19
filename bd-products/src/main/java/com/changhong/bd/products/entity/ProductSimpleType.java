package com.changhong.bd.products.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao
 * @date 2014年7月19日
 * @email yao.qi@changhong.com
 * @description 商品简单分类
 *
 */
@Entity
@Table(name="product_simple_type")
public class ProductSimpleType extends AbsTxNameEntity{

	private static final long serialVersionUID = -1168602893159681098L;

	
}
