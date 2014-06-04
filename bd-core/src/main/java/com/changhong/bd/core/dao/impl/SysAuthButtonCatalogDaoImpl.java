package com.changhong.bd.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.api.SysAuthButtonCatalogDao;
import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.core.entity.SysAuthButtonCatalogEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 按钮权限目录
 */
@Repository("sysAuthButtonCatalogDao")
public class SysAuthButtonCatalogDaoImpl extends MainHibernateDao<SysAuthButtonCatalogEntity, String> implements SysAuthButtonCatalogDao{

}
