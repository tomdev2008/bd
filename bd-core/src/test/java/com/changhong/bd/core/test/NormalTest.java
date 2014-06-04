package com.changhong.bd.core.test;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月13日
 * @version 1.0
 * @description : core模块独立的单元测试，不加载运行环境
 */
public class NormalTest {
	private PasswordService svc = new DefaultPasswordService(); 
	/**
	 * 密码加密测试
	 */
	@Test
	public void testPasswordEncord(){
		String ps = this.svc.encryptPassword("10000");
		System.out.println(ps);
		String pd = "$shiro1$SHA-256$500000$b4R0kLvxyHiQw1+dAM1lPQ==$X7hUIXM1oCaHeqD3ONDbt8U/s3vQzm/mjxb2laq6YFg=";
		System.out.println(pd);
		System.out.println(ps.length());
		boolean rs = this.svc.passwordsMatch("10000",pd);
		Assert.isTrue(rs);
	}
}
