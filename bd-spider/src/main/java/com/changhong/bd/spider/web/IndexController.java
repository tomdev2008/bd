package com.changhong.bd.spider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.spider.service.api.SpiderRespService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
@Controller
@RequestMapping(value="/index")
public class IndexController {
	@Autowired
	private SpiderRespService spiderRespService;
	
	@RequestMapping(value="")
	public String page(){
		return "index";
	}
	
	@RequestMapping(value="hello")
	@ResponseBody
	public String hello(){
		System.out.println(System.getProperty("file.encoding"));
		return this.spiderRespService.hello();
	}
	
	@RequestMapping(value="test", produces="application/json;charset=utf-8")
	@ResponseBody
	public String test(){
		return "中文";
	}
}
