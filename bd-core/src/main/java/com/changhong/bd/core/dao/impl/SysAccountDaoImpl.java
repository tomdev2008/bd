package com.changhong.bd.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.api.SysAccountDao;
import com.changhong.bd.core.entity.SysAccountEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 系统操作人员账户的dao
 */
@Repository("sysAccountDao")
public class SysAccountDaoImpl extends MainHibernateDao<SysAccountEntity, String> implements SysAccountDao{

}
