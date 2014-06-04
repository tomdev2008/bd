package com.changhong.bd.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.api.SysAuthButtonDao;
import com.changhong.bd.core.entity.SysAuthButtonEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 按钮权限 Dao 
 */
@Repository("sysAuthButtonDao")
public class SysAuthButtonDaoImpl extends MainHibernateDao<SysAuthButtonEntity, String> implements SysAuthButtonDao {

}
