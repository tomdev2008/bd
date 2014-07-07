package com.changhong.bd.quartz.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.quartz.domain.QuartzTaskDto;
import com.changhong.bd.quartz.entity.QuartzTask;
import com.changhong.bd.quartz.service.api.QuartzTaskService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 对调度任务进行单元测试
 *
 */
public class TestForQuartzTaskService extends AbstractTestRunner{

	@Autowired
	private QuartzTaskService quartzTaskService;
	
	private QuartzTaskDto dto = null;
	
	@Before
	public void testAdd(){
		QuartzTask e = new QuartzTask();
		
		dto = this.quartzTaskService.add(e);
	}
	
	@Test
	public void testQuery(){
		out(this.quartzTaskService.query(1, 10));
	}
	
	@After
	public void testDelete(){
		if(null!=dto){
			this.quartzTaskService.delete(dto.getId());
		}
	}
}
