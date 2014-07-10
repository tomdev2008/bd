package com.changhong.bd.quartz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.utils.PageUtils;
import com.changhong.bd.quartz.dao.api.QuartzTaskImplClassDao;
import com.changhong.bd.quartz.domain.QuartzTaskImplClassDto;
import com.changhong.bd.quartz.entity.QuartzTaskImplClass;
import com.changhong.bd.quartz.service.api.QuartzTaskImplClassService;

/**
 * @author QiYao
 * @date 2014年7月10日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Service("quartzTaskImplClassService")
@Transactional(readOnly=true)
public class QuartzTaskImplClassServiceImpl 
	implements QuartzTaskImplClassService{

	@Autowired
	private QuartzTaskImplClassDao quartzTaskImplClassDao;
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskImplClassService#query(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public JsonPageData<QuartzTaskImplClassDto> query(Integer pageNo,
			Integer pageSize) {
		DetachedCriteria dc = this.quartzTaskImplClassDao.createDetachedCriteria();
		Long count = this.quartzTaskImplClassDao.queryRowCount();
		
		Integer[] ps = PageUtils.page(pageNo, pageSize);
		List<QuartzTaskImplClass> liste = this.quartzTaskImplClassDao.queryByCriteria(dc, ps[0], pageSize);
		
		List<QuartzTaskImplClassDto> list = new ArrayList<QuartzTaskImplClassDto>();
		
		for(QuartzTaskImplClass e : liste){
			QuartzTaskImplClassDto o = new QuartzTaskImplClassDto();
			BeanUtils.copyProperties(e, o);
			list.add(o);
		}
		
		JsonPageData<QuartzTaskImplClassDto> jpd = new JsonPageData<QuartzTaskImplClassDto>(pageNo, pageSize, count, list);
		
		return jpd;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskImplClassService#add(com.changhong.bd.quartz.entity.QuartzTaskImplClass)
	 */
	@Override
	@Transactional(readOnly=false)
	public QuartzTaskImplClassDto add(QuartzTaskImplClass e) {
		e = this.quartzTaskImplClassDao.save(e);
		QuartzTaskImplClassDto o = new QuartzTaskImplClassDto();
		BeanUtils.copyProperties(e, o);
		
		return o;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskImplClassService#update(com.changhong.bd.quartz.entity.QuartzTaskImplClass)
	 */
	@Override
	@Transactional(readOnly=false)
	public QuartzTaskImplClassDto update(QuartzTaskImplClass e) {
		this.quartzTaskImplClassDao.update(e);
		QuartzTaskImplClassDto o = new QuartzTaskImplClassDto();
		BeanUtils.copyProperties(e, o);
		
		return o;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskImplClassService#query(java.lang.String)
	 */
	@Override
	public QuartzTaskImplClass query(String id) {
		return this.quartzTaskImplClassDao.query(id);
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskImplClassService#delete(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(String id) {
		this.quartzTaskImplClassDao.deleteByKey(id);
	}

}
