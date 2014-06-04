package com.changhong.bd.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.api.SysUserDao;
import com.changhong.bd.core.entity.SysUserEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 系统用户Dao
 */
@Repository("sysUserDao")
public class SysUserDaoImpl extends MainHibernateDao<SysUserEntity,String> implements SysUserDao{

}
