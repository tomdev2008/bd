package com.changhong.bd.quartz.test;

import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
/**
 *
 * @author QiYao
 *
 */
public class SimpleTest {

	/**
	 * 简单任务测试
	 * @throws SchedulerException
	 */
	@Test
	public void testQuartzSimpleStart() throws SchedulerException{
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		scheduler.start();
		
		scheduler.shutdown();
	}
}
