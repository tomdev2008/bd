package com.changhong.bd.spider.service.impl;

import org.springframework.stereotype.Service;

import com.changhong.bd.spider.service.api.SpiderRespService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
@Service("spiderRespService")
public class SpiderRespServiceImpl implements SpiderRespService {

	@Override
	public String hello() {
		return "haha";
	}

}
