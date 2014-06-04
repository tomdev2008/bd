package com.changhong.bd.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.domain.SysUserDto;
import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.core.service.api.SysUserService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 操作人员账户控制器<br/>
 * 	<p>REST路径： /sys/account
 */
@Controller
@RequestMapping(value="/sys/account")
public class SysAccountController {
	/**
	 * 初始化密码
	 */
	public static final String INIT_PASSWORD = "123456";
	@Autowired
	private SysAccountService sysAccountService;
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 分页查询用户信息数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public JsonPageData<SysAccountDto> query(
			@RequestParam(value="pageNo") Integer pageNo,
			@RequestParam(value="pageSize") Integer pageSize
			){
		JsonPageData<SysAccountDto> jpd = this.sysAccountService.query(pageNo, pageSize);
		return jpd;
	}
	
	/**
	 * 通过员工编号查询用户的信息
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/userid/{userid}",method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public SysAccountDto queryByUserId(@PathVariable(value="userid") String userid){
		SysAccountDto dto = this.sysAccountService.queryByUserId(userid);
		return dto;
	}
	/**
	 * 通过user信息创建account
	 * @param e
	 * @return
	 */
	@RequestMapping(value="/userid/{id}",method=RequestMethod.POST,produces=Produces.JSON_STRING)
	@ResponseBody
	public SysAccountDto add(@PathVariable(value="id") String id){
		SysUserDto ud = this.sysUserService.queryUser(id);
		
		SysAccountEntity entity = new SysAccountEntity();

		entity.setPlainPassword(INIT_PASSWORD);
		entity.setLoginName(ud.getUserId());
		entity.setName(ud.getName());
		
		SysUserEntity sysUser = new SysUserEntity();
		sysUser.setId(ud.getId());
		entity.setSysUser(sysUser );
		
		entity = this.sysAccountService.addAccount(entity);
		return new SysAccountDto(entity);
	}
}
