package com.changhong.bd.quartz.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.quartz.domain.QuartzTaskImplClassDto;
import com.changhong.bd.quartz.entity.QuartzTaskImplClass;
import com.changhong.bd.quartz.service.api.QuartzTaskImplClassService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao
 * @date 2014年7月10日
 * @email yao.qi@changhong.com
 * @description 单元测试：定时任务实现类管理服务
 *
 */
public class TestForQuartzTaskImplClassService 
	extends AbstractTestRunner{

	@Autowired
	private QuartzTaskImplClassService quartzTaskImplClassService;
	
	private QuartzTaskImplClassDto dto = null;
	
	@Before
	public void add(){
		QuartzTaskImplClass e = new QuartzTaskImplClass();
		dto = this.quartzTaskImplClassService.add(e);
	}
	
	@Test
	public void query(){
		out(this.quartzTaskImplClassService.query(1, 10));
	}
	
	@After
	public void delete(){
		if(null!=dto){
			this.quartzTaskImplClassService.delete(dto.getId());
		}
	}
	
}
