package com.changhong.bd.products.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.products.dao.api.ProductProcessGroupDao;
import com.changhong.bd.products.entity.ProductProcessGroup;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Repository
public class ProductProcessGroupDaoImpl extends MainHibernateDao<ProductProcessGroup, String>
	implements ProductProcessGroupDao{

}
