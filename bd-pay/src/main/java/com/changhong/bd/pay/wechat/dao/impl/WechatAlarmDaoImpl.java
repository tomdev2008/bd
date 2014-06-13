package com.changhong.bd.pay.wechat.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.pay.entity.WechatAlarmEntity;
import com.changhong.bd.pay.wechat.dao.api.WechatAlarmDao;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 
 */
@Repository("wechatAlarmDao")
public class WechatAlarmDaoImpl 
	extends MainHibernateDao<WechatAlarmEntity, String>
	implements WechatAlarmDao{

}
