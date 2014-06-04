package com.changhong.bd.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.dao.api.SysAuthButtonCatalogDao;
import com.changhong.bd.core.dao.api.SysAuthMenuCatalogDao;
import com.changhong.bd.core.dao.impl.SysAuthButtonDaoImpl;
import com.changhong.bd.core.domain.SysAuthMenuCatalogDto;
import com.changhong.bd.core.entity.SysAuthButtonEntity;
import com.changhong.bd.core.entity.SysAuthButtonCatalogEntity;
import com.changhong.bd.core.entity.SysAuthMenuCatalogEntity;
import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.core.service.api.SysAuthService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 
 */
@Service("sysAuthService")
@Transactional(readOnly=true)
public class SysAuthServiceImpl implements SysAuthService {

	@Autowired
	private SysAuthButtonDaoImpl sysAuthButtonDao;
	
	@Autowired
	private SysAuthButtonCatalogDao sysAuthButtonCatalogDao;
	
	@Autowired
	private SysAuthMenuCatalogDao sysAuthMenuCatalogDao;
	
	@Override
	@Transactional(readOnly=false)
	public void addAuthBtn(SysAuthButtonEntity btn) {
		this.sysAuthButtonDao.save(btn);
	}

	@Override
	@Transactional(readOnly=false)
	public void updateAuthBtn(SysAuthButtonEntity btn) {
		this.sysAuthButtonDao.update(btn);
	}

	@Override
	@Transactional(readOnly=false)
	public void addAuthBtnCatalog(SysAuthButtonCatalogEntity btnCatalog) {
		this.sysAuthButtonCatalogDao.save(btnCatalog);
	}

	@Override
	@Transactional(readOnly=false)
	public void updateAuthBtnCatalog(SysAuthButtonCatalogEntity btnCatalog) {
		this.sysAuthButtonCatalogDao.save(btnCatalog);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteAuthBtn(String id) {
		this.sysAuthButtonDao.deleteByKey(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteAuthCatalog(String id) {
		this.sysAuthButtonCatalogDao.deleteByKey(id);
	}

	@Override
	public JsonData<SysAuthMenuCatalogDto> queryAllMenuCatalog() {
		DetachedCriteria dc = this.sysAuthMenuCatalogDao.createDetachedCriteria();
		Criterion c = Restrictions.eq("status", 1);
		dc.add(c);
		
		List<SysAuthMenuCatalogEntity> liste = this.sysAuthMenuCatalogDao.queryByCriteria(dc);
		List<SysAuthMenuCatalogDto> listd = new ArrayList<SysAuthMenuCatalogDto>();
		if(null!=liste && liste.size()>0){
			for(SysAuthMenuCatalogEntity i : liste){
				listd.add(new SysAuthMenuCatalogDto(i, false, true));
			}
		}
		JsonData<SysAuthMenuCatalogDto> jd = new JsonData<SysAuthMenuCatalogDto>(0L, listd);
		return jd;
	}

}
