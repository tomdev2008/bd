package com.changhong.bd.quartz.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.quartz.dao.api.QuartzTaskImplClassDao;
import com.changhong.bd.quartz.entity.QuartzTaskImplClass;

/**
 * @author QiYao
 * @date 2014年7月10日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Repository
public class QuartzTaskImplClassDaoImpl 
	extends MainHibernateDao<QuartzTaskImplClass, String>
	implements QuartzTaskImplClassDao{

}
