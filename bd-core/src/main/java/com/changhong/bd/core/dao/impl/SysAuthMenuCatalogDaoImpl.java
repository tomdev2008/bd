package com.changhong.bd.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.api.SysAuthMenuCatalogDao;
import com.changhong.bd.core.entity.SysAuthMenuCatalogEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 
 */
@Repository("sysAuthMenuCatalogDao")
public class SysAuthMenuCatalogDaoImpl
	extends MainHibernateDao<SysAuthMenuCatalogEntity, String>
	implements SysAuthMenuCatalogDao{

}
