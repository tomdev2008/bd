package com.changhong.bd.quartz.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.utils.PageUtils;
import com.changhong.bd.quartz.dao.api.QuartzTaskDao;
import com.changhong.bd.quartz.domain.QuartzTaskDto;
import com.changhong.bd.quartz.entity.QuartzTask;
import com.changhong.bd.quartz.service.api.QuartzTaskService;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Service("QuartzTaskService")
@Transactional(readOnly=true)
public class QuartzTaskServiceImpl implements QuartzTaskService{

	@Autowired
	private QuartzTaskDao quartzTaskDao;
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskService#query(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public JsonPageData<QuartzTask> query(Integer pageNo, Integer pageSize,
			DateTime startTime) {
		DetachedCriteria dc = this.quartzTaskDao.createDetachedCriteria();
		DetachedCriteria cdc = this.quartzTaskDao.createDetachedCriteria();
		
		if(null!=startTime){
			SimpleExpression se = Restrictions.lt("startDate", startTime);
			dc.add(se);
			cdc.add(se);
		}
		
		Long count = this.quartzTaskDao.queryRowCount(cdc);
		List<QuartzTask> list = null;
		
		if(null!=pageNo && null!=pageSize){
			Integer ps[] = PageUtils.page(pageNo, pageSize);
			list = this.quartzTaskDao.queryByCriteria(dc, ps[0], pageSize);
		}else{
			list = this.quartzTaskDao.queryByCriteria(dc);
		}
		
		JsonPageData<QuartzTask> jpd = new JsonPageData<QuartzTask>(pageNo, pageSize, count, list);
		return jpd;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskService#add(com.changhong.bd.quartz.entity.QuartzTask)
	 */
	@Override
	@Transactional(readOnly=false)
	public QuartzTaskDto add(QuartzTask e) {
		QuartzTaskDto dto = new QuartzTaskDto();
		this.quartzTaskDao.save(e);
		BeanUtils.copyProperties(e, dto);
		
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskService#delete(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(String id) {
		this.quartzTaskDao.deleteByKey(id);
	}

}