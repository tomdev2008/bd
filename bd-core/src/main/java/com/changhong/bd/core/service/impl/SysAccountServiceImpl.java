package com.changhong.bd.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.dao.api.SysAccountDao;
import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.domain.SysUserDto;
import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.core.service.api.SysUserService;
import com.changhong.bd.core.utils.Digests;
import com.changhong.bd.core.utils.Encodes;
import com.changhong.bd.core.utils.PageUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 
 */
@Service("sysAccountService")
@Transactional(readOnly=true)
public class SysAccountServiceImpl implements SysAccountService {

	private static Logger logger = LoggerFactory.getLogger(SysAccountServiceImpl.class);
	@Autowired
	private SysAccountDao sysAccountDao;
	
	@Autowired
	private SysUserService sysUserService;
	
	@Override
	@Transactional(readOnly=false)
	public SysAccountEntity addAccount(SysAccountEntity entity){
		this.entryptPassword(entity);
		return this.sysAccountDao.save(entity);
	}
	
	@Override
	public SysAccountEntity queryUserByLoginName(String username) {
		DetachedCriteria criteria = this.sysAccountDao.createDetachedCriteria();
		criteria.add(Restrictions.eq("loginName", username));
		List<SysAccountEntity> list = this.sysAccountDao.queryByCriteria(criteria);
		 
		if(list.size()<1){
			return null;
		}else{
			return list.get(0);
		}
	}


	@Override
	public SysAccountDto queryById(String id) {
		SysAccountEntity e = this.sysAccountDao.query(id);
		if(null==e){
			return null;
		}
		return new SysAccountDto(e);
	}

	public void entryptPassword(SysAccountEntity account) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		
		String salts = Encodes.encodeHex(salt);
		logger.info("salt:{}", salts);
		
		account.setSalt(salts);

		byte[] hashPassword = Digests.sha1(account.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		String hp = Encodes.encodeHex(hashPassword);
		logger.info("password:{}",hp);
		account.setPassword(hp);
	}

	@Override
	public JsonPageData<SysAccountDto> query(Integer pageNo, Integer pageSize) {
		DetachedCriteria dc = this.sysAccountDao.createDetachedCriteria();
		DetachedCriteria cdc = this.sysAccountDao.createDetachedCriteria();
		
		Long count = this.sysAccountDao.queryRowCount(cdc);
		List<SysAccountEntity> list = null;
		if(null!=pageNo && null!=pageSize){
			Integer is[] = PageUtils.page(pageNo, pageSize);
			list = this.sysAccountDao.queryByCriteria(dc, is[0], is[1]);
		}else{
			list = this.sysAccountDao.queryByCriteria(dc);
		}
		List<SysAccountDto> listd = new ArrayList<SysAccountDto>();
		if(null!=list){
			for(SysAccountEntity e : list){
				listd.add(new SysAccountDto(e));
			}
		}
		
		JsonPageData<SysAccountDto> jpd = new JsonPageData<SysAccountDto>(pageNo, pageSize, count, listd);
		
		return jpd;
	}

	@Override
	public SysAccountDto queryByUserId(String userid) {
		SysUserDto ud = this.sysUserService.queryByUserId(userid);
		
		if(null==ud){
			return null;
		}
		
		SysUserEntity ue = new SysUserEntity();
		ue.setId(ud.getId());
		
		DetachedCriteria dc = this.sysAccountDao.createDetachedCriteria();
		dc.add(Restrictions.eq("sysUser", ue));
		
		List<SysAccountEntity> list = this.sysAccountDao.queryByCriteria(dc);
		if(null!=list && list.size()>0){
			return new SysAccountDto(list.get(0));
		}else {
			return null;
		}
	}
}
