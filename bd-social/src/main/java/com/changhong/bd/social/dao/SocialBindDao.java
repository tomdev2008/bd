package com.changhong.bd.social.dao;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.social.entity.SocialBindEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月14日
 * @version 1.0
 * @description : 社交绑定Dao
 */
@Repository("socialBindDao")
public class SocialBindDao extends MainHibernateDao<SocialBindEntity,String>{

}
