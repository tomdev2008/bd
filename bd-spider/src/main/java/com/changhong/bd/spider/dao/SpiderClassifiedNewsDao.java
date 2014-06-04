package com.changhong.bd.spider.dao;

import org.springframework.stereotype.Repository;

import com.changhong.bd.spider.entity.SpiderClassifiedNews;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 爬虫分类新闻的Dao
 */

@Repository("spiderClassifiedNewsDao")
public class SpiderClassifiedNewsDao extends SpiderHibernateDao<SpiderClassifiedNews, String> {

}
