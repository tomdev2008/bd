package com.changhong.bd.spider.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.utils.PageUtils;
import com.changhong.bd.spider.dao.SpiderClassifiedNewsDao;
import com.changhong.bd.spider.entity.SpiderClassifiedNews;
import com.changhong.bd.spider.service.api.SpiderNewsService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 
 */
@Service("spiderNewsService")
public class SpiderNewsServiceImpl implements SpiderNewsService {

	@Autowired
	private SpiderClassifiedNewsDao spiderClassifiedNewsDao;
	
	@Override
	public JsonPageData<SpiderClassifiedNews> query(Integer pageNo, Integer pageSize, String title, String category, String url) {
		DetachedCriteria criteria = this.spiderClassifiedNewsDao.createDetachedCriteria();
		if(StringUtils.isNotEmpty(title)){
			criteria.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
		}
		List<SpiderClassifiedNews> list;
		//TODO category and url query
		
		//按照时间降序排列
		criteria.addOrder(Order.desc("classifyDate"));
		if(null!=pageNo && null!=pageSize){
			Integer[] ps = PageUtils.page(pageNo, pageSize);
			list = this.spiderClassifiedNewsDao.queryByCriteria(criteria, ps[0], ps[1]);
		}else{
			list = this.spiderClassifiedNewsDao.queryByCriteria(criteria);
		}
		
		Long count = this.spiderClassifiedNewsDao.queryRowCount(criteria);
		
		JsonPageData<SpiderClassifiedNews> jpd = new JsonPageData<SpiderClassifiedNews>(pageNo, pageSize, count, list);
		return jpd;
	}

}
