package com.changhong.bd.quartz.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.quartz.dao.api.QuartzTaskLogDao;
import com.changhong.bd.quartz.entity.QuartzTaskLog;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Repository
public class QuartzTaskLogDaoImpl 
	extends MainHibernateDao<QuartzTaskLog, String>
	implements QuartzTaskLogDao{

}
