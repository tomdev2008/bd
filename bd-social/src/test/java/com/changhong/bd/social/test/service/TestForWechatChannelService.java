package com.changhong.bd.social.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.social.entity.WechatChannelEntity;
import com.changhong.bd.social.service.api.WechatChannelService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月19日
 * @version 1.0
 * @description : 
 */
public class TestForWechatChannelService 
	extends AbstractTestRunner{

	@Autowired
	private WechatChannelService service;
	
	private WechatChannelEntity entity = null;
	
	@Test
	public void testQuery(){
		out(this.service.queryCurrent("wechatOpenId"));
		out(this.service.queryCurrent("xkjdflsdf"));
	}
	
	@Before
	public void testAdd(){
	
		entity = new WechatChannelEntity("name",
				"wechatOpenId", 
				"wechatChannelId", 
				"wechatChannelName", 
				"channelInfo");
		
		this.service.add(entity );
	}
	
	@After
	public void testDelete(){
		if(null!=entity){
			this.service.delete(entity.getId());
		}
	}
}
