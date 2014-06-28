package com.changhong.bd.social.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.social.domain.WechatQrcodeDto;
import com.changhong.bd.social.service.api.WechatQrcodeService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * Test for WechatQrcodeService
 * @author Sunrui
 * @date 2014年6月28日
 */
public class TestForWechatQrcodeService extends AbstractTestRunner{

	@Autowired
	private WechatQrcodeService wechatQrcodeService;
	
	@Test
	public void testCreateQrcodeImageUrl(){
		WechatQrcodeDto dto = new WechatQrcodeDto();
		dto.setId("thisisid");
		out("ever image url:");
		out(this.wechatQrcodeService.createCode(dto));
		
		dto.setExpireTime(1800);
		out("tmp image url:");
		out(this.wechatQrcodeService.createCode(dto));
	}
}
