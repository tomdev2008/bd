package com.changhong.bd.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.dao.api.SysOrganizationDao;
import com.changhong.bd.core.entity.SysOrganizationEntity;
import com.changhong.bd.core.service.api.SysOrganizationService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 
 */
@Service("sysOrganizationService")
@Transactional(readOnly=true)
public class SysOrganizationServiceImpl implements SysOrganizationService{

	@Autowired
	private SysOrganizationDao sysOrganizationDao;
	
	@Transactional(readOnly=false)
	@Override
	public void saveOrg(SysOrganizationEntity entity) {
		this.sysOrganizationDao.save(entity);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void deleteOrg(String id){
		this.sysOrganizationDao.deleteByKey(id);
	}

}
