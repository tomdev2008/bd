package com.changhong.bd.social.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.social.dao.SocialBindDao;
import com.changhong.bd.social.entity.SocialBindEntity;
import com.changhong.bd.social.service.api.SocialService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 
 */
@Service("socialService")
@Transactional(readOnly=true)
public class SocialServiceImpl implements SocialService{

	@Autowired
	private SocialBindDao socialBindDao;
	
	@Override
	public List<SocialBindEntity> queryByOpenId(String type, String openId) {
		DetachedCriteria criteria = this.socialBindDao.createDetachedCriteria();
		criteria.add(Restrictions.eq("bindType", type));
		criteria.add(Restrictions.eq("openId", openId));
		List<SocialBindEntity> list = this.socialBindDao.queryByCriteria(criteria);
		return list;
	}

	@Override
	public List<SocialBindEntity> queryByUserId(String type, String userId) {
		DetachedCriteria dc = this.socialBindDao.createDetachedCriteria();
		dc.add(Restrictions.eq("bindType", type));
		dc.add(Restrictions.eq("accountId", userId));
		return this.socialBindDao.queryByCriteria(dc);
	}

	@Override
	@Transactional(readOnly=false)
	public SocialBindEntity addLink(String userId, String type, String openId) {
		//this.queryUserId(type, openId)
		SocialBindEntity e = new SocialBindEntity(type, openId, userId);
		return this.socialBindDao.save(e);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void deleteLink(String id){
		this.socialBindDao.deleteByKey(id);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void deleteLink(SocialBindEntity entity){
		this.socialBindDao.delete(entity);
	}
}
