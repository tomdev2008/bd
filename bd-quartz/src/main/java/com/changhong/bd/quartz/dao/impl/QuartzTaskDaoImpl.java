package com.changhong.bd.quartz.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.quartz.dao.api.QuartzTaskDao;
import com.changhong.bd.quartz.entity.QuartzTask;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 调度任务dao 
 *
 */
@Repository
public class QuartzTaskDaoImpl 
	extends MainHibernateDao<QuartzTask, String>
	implements QuartzTaskDao{

}
