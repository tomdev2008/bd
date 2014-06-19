package com.changhong.bd.social.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.utils.BeanUtils;
import com.changhong.bd.social.dao.WechatChannelDao;
import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.entity.WechatChannelEntity;
import com.changhong.bd.social.service.api.WechatChannelService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月18日
 * @version 1.0
 * @description : 
 */
@Service("weechatChannelService")
@Transactional(readOnly=true)
public class WechatChannelServiceImpl 
	implements WechatChannelService{

	@Autowired
	private WechatChannelDao wechatChannelDao;
	
	@Override
	public WechatChannelDto queryCurrent(String openId) {
		DetachedCriteria dc = this.wechatChannelDao.createDetachedCriteria();
		
		/**
		 * 1.相同的open id
		 * 2.在有效期内
		 * 3.按有效期排序，使用最大的有效期
		 */
		dc.add(Restrictions.eq("wechatOpenId", openId));
		dc.add(Restrictions.gt("expireTime", new DateTime()));
		dc.addOrder(Order.desc("expireTime"));
		
		List<WechatChannelEntity> liste = this.wechatChannelDao.queryByCriteria(dc);
		if(null!=liste && liste.size()>0){
			return this.transfer(liste.get(0));
		}
		return null;
	}

	private WechatChannelDto transfer(WechatChannelEntity wechatChannelEntity) {
		WechatChannelDto dto = new WechatChannelDto();
		BeanUtils.copyProperties(dto, wechatChannelEntity);
		return dto;
	}

	@Override
	@Transactional(readOnly=false)
	public WechatChannelDto add(WechatChannelEntity entity){
		this.wechatChannelDao.save(entity);
		return this.transfer(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(String id) {
		this.wechatChannelDao.deleteByKey(id);
	}
}
