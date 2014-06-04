package com.changhong.bd.core.test.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.core.domain.SysUserDto;
import com.changhong.bd.core.entity.SysRegionEntity;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.service.api.SysUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 单元测试：系统用户 
 */
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml"
})
public class TestForSysUserService extends AbstractJUnit4SpringContextTests {

	private static Logger logger = LoggerFactory.getLogger(TestForSysUserService.class);
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 测试通过ID查询
	 * @throws JsonProcessingException
	 */
	@Test
	public void testQueryById() throws JsonProcessingException{
		SysUserDto d = this.sysUserService.queryUser("01");
		String s = om.writeValueAsString(d);
		logger.info(s);
	}
	/**
	 * 测试用户分页信息
	 * @throws JsonProcessingException 
	 */
	@Test
	public void testQueryUserPage() throws JsonProcessingException{
		JsonPageData<SysUserDto> jpd = this.sysUserService.queryUser(null, null, "漆尧");
		jpd = this.sysUserService.queryUser(1, 10, "漆尧");
		String s = om.writeValueAsString(jpd);
		logger.info(s);
	}
	/**
	 * 测试添加用户
	 */
	@Test
	public void testAddUserEntity(){
		SysUserEntity e = new SysUserEntity();
		
		e.setName("漆尧");
		e.setAddress("游仙区桑林坝8号");
		e.setEmail("yao.qi@changhong.com");
		e.setPhone("18628209093");
		e.setUserId("201488152");
		
		SysRegionEntity r = new SysRegionEntity();
		r.setId("0");
		e.setRegion(r);
		
		e = this.sysUserService.addUser(e);
		
		e.setEmail("updated email");
		this.sysUserService.updateUser(e);
		
		this.sysUserService.deleteUser(e.getId());
	}
	
}
