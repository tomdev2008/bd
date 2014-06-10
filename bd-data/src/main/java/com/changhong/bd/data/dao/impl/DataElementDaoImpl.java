package com.changhong.bd.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.data.dao.api.DataElementDao;
import com.changhong.bd.data.entity.DataElementEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月9日
 * @version 1.0
 * @description : 
 */
@Repository("dataElementDao")
public class DataElementDaoImpl 
	extends MainHibernateDao<DataElementEntity, String >
	implements DataElementDao{

}
