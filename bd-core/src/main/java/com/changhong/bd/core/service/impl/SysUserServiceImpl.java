package com.changhong.bd.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.dao.api.SysUserDao;
import com.changhong.bd.core.domain.SysUserDto;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.service.api.SysUserService;
import com.changhong.bd.core.utils.PageUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月26日
 * @version 1.0
 * @description : 
 */
@Service("sysUserService")
@Transactional(readOnly=true)
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public JsonPageData<SysUserDto> queryUser(Integer pageNo, Integer pageSize, String name) {
		DetachedCriteria dc = this.sysUserDao.createDetachedCriteria();
		DetachedCriteria cdc = this.sysUserDao.createDetachedCriteria();
		if(StringUtils.isNotEmpty(name)){
			SimpleExpression se = Restrictions.eq("name", name);
			dc.add(se);
			cdc.add(se);
		}
		Long count = this.sysUserDao.queryRowCount(cdc);
		List<SysUserEntity> list;
		if(null!=pageSize && null!=pageNo){
			Integer is[] = PageUtils.page(pageNo, pageSize);
			list = this.sysUserDao.queryByCriteria(dc, is[0], is[1]);
		}else{
			list = this.sysUserDao.queryByCriteria(dc);
		}
		List<SysUserDto> listd = new ArrayList<SysUserDto>();
		if(null!=list && list.size()>0){
			for(SysUserEntity e : list){
				listd.add(new SysUserDto(e));
			}
		}
		
		JsonPageData<SysUserDto> jpd = new JsonPageData<SysUserDto>(pageNo, pageSize, count, listd);
		return jpd;
	}

	@Override
	@Transactional(readOnly=false)
	public SysUserEntity addUser(SysUserEntity e) {
		return this.sysUserDao.save(e);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteUser(String id) {
		this.sysUserDao.deleteByKey(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void updateUser(SysUserEntity entity) {
		this.sysUserDao.update(entity);
	}

	@Override
	public SysUserDto queryUser(String id) {
		SysUserEntity e = this.sysUserDao.query(id);
		SysUserDto d = new SysUserDto(e);
		return d;
	}

	@Override
	public SysUserDto queryByUserId(String userid) {
		DetachedCriteria dc = this.sysUserDao.createDetachedCriteria();
		dc.add(Restrictions.eq("userId", userid));
		List<SysUserEntity> list = this.sysUserDao.queryByCriteria(dc);
		
		if(null!=list && list.size()>0){
			return new SysUserDto(list.get(0));
		}else{
			return null;
		}
	}

}
