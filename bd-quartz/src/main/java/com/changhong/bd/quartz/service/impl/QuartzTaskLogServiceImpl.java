package com.changhong.bd.quartz.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.utils.PageUtils;
import com.changhong.bd.quartz.dao.api.QuartzTaskLogDao;
import com.changhong.bd.quartz.domain.QuartzTaskLogDto;
import com.changhong.bd.quartz.entity.QuartzTaskLog;
import com.changhong.bd.quartz.service.api.QuartzTaskLogService;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 任务调度日志服务
 *
 */
@Service("quartzTaskLogService")
@Transactional(readOnly=false)
public class QuartzTaskLogServiceImpl implements QuartzTaskLogService{

	@Autowired
	private QuartzTaskLogDao quartzTaskLogDao;
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskLogService#query(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public JsonPageData<QuartzTaskLog> query(Integer pageNo, Integer pageSize) {
		Long count = this.quartzTaskLogDao.queryRowCount();
		Integer ps[] = PageUtils.page(pageNo, pageSize);
		DetachedCriteria dc = this.quartzTaskLogDao.createDetachedCriteria();
		List<QuartzTaskLog> list = this.quartzTaskLogDao.queryByCriteria(dc, ps[0], pageSize);
		JsonPageData<QuartzTaskLog> jpd = new JsonPageData<QuartzTaskLog>(pageNo, pageSize, count, list);
		return jpd;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskLogService#add(com.changhong.bd.quartz.entity.QuartzTaskLog)
	 */
	@Override
	@Transactional(readOnly=false)
	public QuartzTaskLogDto add(QuartzTaskLog e) {
		this.quartzTaskLogDao.save(e);
		QuartzTaskLogDto dto = new QuartzTaskLogDto();
		BeanUtils.copyProperties(e, dto);
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.quartz.service.api.QuartzTaskLogService#delete(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(String id) {
		this.quartzTaskLogDao.deleteByKey(id);
	}

}
