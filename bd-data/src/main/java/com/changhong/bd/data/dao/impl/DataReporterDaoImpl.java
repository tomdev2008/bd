package com.changhong.bd.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.data.dao.api.DataReporterDao;
import com.changhong.bd.data.entity.DataReporterEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月11日
 * @version 1.0
 * @description : 
 */
@Repository("dataReporterDao")
public class DataReporterDaoImpl 
	extends MainHibernateDao<DataReporterEntity, String>
	implements DataReporterDao{

}
