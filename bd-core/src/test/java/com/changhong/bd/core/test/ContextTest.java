package com.changhong.bd.core.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.entity.SysAuthButtonEntity;
import com.changhong.bd.core.entity.SysAuthButtonCatalogEntity;
import com.changhong.bd.core.entity.SysOrganizationEntity;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.core.service.api.SysAuthService;
import com.changhong.bd.core.service.api.SysOrganizationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml"
})
public class ContextTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private SysOrganizationService sysOrganizationService;
	@Autowired
	private SysAccountService sysAccountService;
	
	private ObjectMapper jsonMapper = new ObjectMapper();

	@Autowired
	@Qualifier("sysAuthService")
	private SysAuthService sysAuthService;
	
	/**
	 * 1.执行单元测试，进行权限按钮与权限目录的添加操作，
	 * 2.在添加完成之后，删除刚刚添加的数据
	 */
	@Test
	public void testCreateAuthBtnAndBtnCatalog(){
		SysAuthButtonCatalogEntity btnCatalog = new SysAuthButtonCatalogEntity();
		btnCatalog.setName("系统按钮");
		this.sysAuthService.addAuthBtnCatalog(btnCatalog );
		
		SysAuthButtonEntity btn = new SysAuthButtonEntity();
		btn.setName("添加用户按钮");
		btn.setCode("SysAccount:Add");
		btn.setCatalog(btnCatalog);
		this.sysAuthService.addAuthBtn(btn);
		this.sysAuthService.deleteAuthBtn(btn.getId());
		this.sysAuthService.deleteAuthCatalog(btnCatalog.getId());
	}
	/**
	 * 测试通过ID查询 dto 账户数据
	 */
	@Test
	public void testQueryAccountById() throws JsonProcessingException{
		SysAccountDto dto = this.sysAccountService.queryById("01");
		System.out.println(jsonMapper.writeValueAsString(dto));
	}
	/**
	 * 测试，通过用户名查找用户
	 */
	@Test
	public void testQueryAccountByLoginname(){
		SysAccountEntity a = this.sysAccountService.queryUserByLoginName("admin");
		Assert.notNull(a);
		a = this.sysAccountService.queryUserByLoginName("hehesbsb");
		Assert.isNull(a);
	}
	/**
	 * 测试添加组织机构
	 */
	@Test
	public void testAddSysOrganization(){
		SysOrganizationEntity entity = new SysOrganizationEntity() ;
		entity.setName("name");
		this.sysOrganizationService.saveOrg(entity );
		this.sysOrganizationService.deleteOrg(entity.getId());
	}
}
