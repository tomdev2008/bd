package com.changhong.bd.products.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.products.dao.api.ProductSimpleTypeDao;
import com.changhong.bd.products.entity.ProductSimpleType;

/**
 * @author QiYao
 * @date 2014年7月19日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Repository
public class ProductSimpleTypeDaoImpl extends MainHibernateDao<ProductSimpleType, String>
	implements ProductSimpleTypeDao{

}
