package com.changhong.bd.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.domain.SysUserDto;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.resp.JsonMessage;
import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.core.service.api.SysUserService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月26日
 * @version 1.0
 * @description : 系统用户REST控制器<br/>
 * 	<p>控制器路径：/sys/user
 */
@Controller
@RequestMapping(value="/sys/user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 查询用户的分页数据
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public JsonPageData<SysUserDto> queryUser(
			@RequestParam(value="pageNo") Integer pageNo,
			@RequestParam(value="pageSize") Integer pageSize,
			@RequestParam(value="name", required=false) String name){
		
		return this.sysUserService.queryUser(pageNo, pageSize, name);
	}
	
	/**
	 * 修改用户信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT,produces="application/json;charset=utf-8")
	@ResponseBody
	public JsonMessage updateUser(
			@PathVariable(value="id") String id,
			SysUserEntity entity){
		this.sysUserService.updateUser(entity);
		JsonMessage jm = new JsonMessage(200, "修改成功");
		return jm;
	}
	/**
	 * 创建用户信息，并返回创建后的数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, produces=Produces.JSON_STRING)
	@ResponseBody
	public SysUserDto createUser(@RequestBody SysUserDto dto){
		SysUserEntity entity = new SysUserEntity(dto);
		entity = this.sysUserService.addUser(entity);
		SysUserDto domain = this.sysUserService.queryUser(entity.getId());
		return domain;
	}
}
