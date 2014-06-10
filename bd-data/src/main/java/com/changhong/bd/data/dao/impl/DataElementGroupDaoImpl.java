package com.changhong.bd.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.data.dao.api.DataElementGroupDao;
import com.changhong.bd.data.entity.DataElementGroupEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月9日
 * @version 1.0
 * @description : 
 */
@Repository("dataElementGroupDao")
public class DataElementGroupDaoImpl 
	extends MainHibernateDao<DataElementGroupEntity, String>
	implements DataElementGroupDao{

}
