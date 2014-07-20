package com.changhong.bd.product.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.products.service.api.ProductSimpleTypeService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 单元测试：商品简单分类服务
 *
 */
public class TestForProductSimpleTypeService extends AbstractTestRunner{

	@Autowired
	private ProductSimpleTypeService productSimpleTypeService;
	
	@Test
	public void testForGet(){
		out(this.productSimpleTypeService.query());
	}
	
}
