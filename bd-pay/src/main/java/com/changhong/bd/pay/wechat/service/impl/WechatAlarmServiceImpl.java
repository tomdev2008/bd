package com.changhong.bd.pay.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.pay.entity.WechatAlarmEntity;
import com.changhong.bd.pay.wechat.dao.api.WechatAlarmDao;
import com.changhong.bd.pay.wechat.service.api.WechatAlarmService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 
 */
@Service("wechatAlarmService")
@Transactional(readOnly=true)
public class WechatAlarmServiceImpl 
	implements WechatAlarmService{

	@Autowired
	private WechatAlarmDao wechatAlarmDao;
	
	@Override
	@Transactional(readOnly=false)
	public void add(WechatAlarmEntity e) {
		this.wechatAlarmDao.save(e);
	}

	
}
