package com.changhong.bd.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.data.dao.api.RepositoryEntityDao;
import com.changhong.bd.data.entity.DataRepositoryEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 
 */
@Repository("repositoryEntityDao")
public class RepositoryEntityDaoImpl extends MainHibernateDao<DataRepositoryEntity, String>
	implements RepositoryEntityDao{

}
