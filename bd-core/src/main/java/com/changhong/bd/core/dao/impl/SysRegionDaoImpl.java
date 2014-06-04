package com.changhong.bd.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.api.SysRegionDao;
import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.core.entity.SysRegionEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 地区Dao 接口
 */
@Repository("sysRegionEntityDao")
public class SysRegionDaoImpl extends MainHibernateDao<SysRegionEntity,String> implements SysRegionDao{

}
