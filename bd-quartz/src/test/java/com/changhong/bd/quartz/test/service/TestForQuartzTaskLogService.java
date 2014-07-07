package com.changhong.bd.quartz.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.quartz.domain.QuartzTaskLogDto;
import com.changhong.bd.quartz.entity.QuartzTaskLog;
import com.changhong.bd.quartz.service.api.QuartzTaskLogService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 单元测试：调度任务日志
 *
 */
public class TestForQuartzTaskLogService extends AbstractTestRunner{

	@Autowired
	private QuartzTaskLogService quartzTaskLogService;
	private QuartzTaskLogDto dto = null;
	
	@Before
	public void testAdd(){
		QuartzTaskLog e = new QuartzTaskLog();
		dto  = this.quartzTaskLogService.add(e );
	}
	
	@Test
	public void testQuery(){
		out(this.quartzTaskLogService.query(1, 10));
	}
	
	@After
	public void testDelte(){
		if(null!=dto){
			this.quartzTaskLogService.delete(dto.getId());
		}
	}
}
