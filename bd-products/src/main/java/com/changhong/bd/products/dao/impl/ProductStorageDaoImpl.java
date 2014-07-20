package com.changhong.bd.products.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.products.dao.api.ProductStorageDao;
import com.changhong.bd.products.entity.ProductStorage;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Repository
public class ProductStorageDaoImpl extends MainHibernateDao<ProductStorage, String>
	implements ProductStorageDao{

}
