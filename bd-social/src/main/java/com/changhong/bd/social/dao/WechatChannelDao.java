package com.changhong.bd.social.dao;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.social.entity.WechatChannelEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月18日
 * @version 1.0
 * @description : 微信 频道 dao
 */
@Repository("socialWechatChannelDao")
public class WechatChannelDao extends MainHibernateDao<WechatChannelEntity, String> {

}
