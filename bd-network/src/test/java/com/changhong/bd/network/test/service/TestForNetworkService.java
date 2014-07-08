package com.changhong.bd.network.test.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.network.service.api.NetworkService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao
 * @date 2014年7月8日
 * @email yao.qi@changhong.com
 * @description 单元测试：网络服务
 *
 */
public class TestForNetworkService extends AbstractTestRunner{

	@Autowired
	private NetworkService networkService;
	
	@Test
	public void testHttpGet(){
		String url = "www.baidu.com";
		Map<String,String> values = new HashMap<String,String>();
		values.put("wd", "httpclient uribuilder");
		out(this.networkService.httpGet(url, values, false));
	}
}
