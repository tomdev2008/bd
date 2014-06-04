package com.changhong.bd.spider.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.spider.entity.SpiderClassifiedNews;
import com.changhong.bd.spider.service.api.SpiderNewsService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月18日
 * @version 1.0
 * @description : 新闻控制器
 */
@Controller
@RequestMapping(value="/spider/news")
public class NewsController {
	
	@Autowired
	private SpiderNewsService spiderNewsService;
	/**
	 * 进入新闻页面
	 * @return
	 */
	@RequestMapping(value="page")
	public String page(){
		return "spider/newspage";
	}
	/**
	 * 查询新闻数据
	 * @param query
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public JsonPageData<SpiderClassifiedNews> queryNews(
			@RequestParam(value="query", required=false, defaultValue="") String query,
			@RequestParam(value="pageNo", required=false, defaultValue="1") Integer pageNo,
			@RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize) throws UnsupportedEncodingException{
		query = URLDecoder.decode(query,"UTF-8");
		return this.spiderNewsService.query(pageNo, pageSize, query, null, null);
	}
}
