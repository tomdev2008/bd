package com.changhong.bd.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.api.SysPropertyDao;
import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.core.entity.SysPropertyEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月4日
 * @version 1.0
 * @description : 
 */
@Repository("sysPropertyDao")
public class SysPropertyDaoImpl 
	extends MainHibernateDao<SysPropertyEntity,String>
	implements SysPropertyDao{

}
