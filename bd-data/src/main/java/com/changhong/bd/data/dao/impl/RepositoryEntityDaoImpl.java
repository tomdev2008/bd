package com.changhong.bd.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.MainHibernateDao;
import com.changhong.bd.data.dao.api.RepositoryEntityDao;
import com.changhong.bd.data.entity.RepositoryEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 
 */
@Repository("repositoryEntityDao")
public class RepositoryEntityDaoImpl extends MainHibernateDao<RepositoryEntity, String>
	implements RepositoryEntityDao{

}
