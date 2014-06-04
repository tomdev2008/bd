package com.changhong.bd.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.dao.api.SysRegionDao;
import com.changhong.bd.core.domain.SysRegionDto;
import com.changhong.bd.core.entity.SysRegionEntity;
import com.changhong.bd.core.service.api.SysRegionService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 
 */
@Service
@Transactional(readOnly=true)
public class SysRegionServiceImpl implements SysRegionService{

	@Autowired
	private SysRegionDao sysRegionDao;
	
	@Override
	public SysRegionDto querySysRegionTree() {
		/**
		 * 1.查询顶级节点，顶级节点的代码为0
		 * 2.通过顶级节点的代码，生成domain对象即可
		 */
		SysRegionEntity entity = this.sysRegionDao.query("0");
		return new SysRegionDto(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public SysRegionEntity addSysRegion(SysRegionEntity entity) {
		return this.sysRegionDao.save(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteSysRegion(String id) {
		SysRegionEntity entity = this.sysRegionDao.query(id);
		this.sysRegionDao.delete(entity);
	}

}
