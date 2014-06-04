package com.changhong.bd.spider.service.api;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.spider.entity.SpiderClassifiedNews;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 爬虫新闻服务
 */
public interface SpiderNewsService {

	/**
	 * 查询新闻
	 * @param title
	 * @param category
	 * @param url
	 * @return
	 */
	public JsonPageData<SpiderClassifiedNews> query(
			Integer pageNo,
			Integer pageSize,
			String title, String category, String url);
}
