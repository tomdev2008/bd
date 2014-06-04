package com.changhong.bd.core.service.api;

import com.changhong.bd.core.domain.SysUserDto;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.resp.JsonPageData;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 员工服务接口
 */
public interface SysUserService {

	/**
	 * 查询用户信息
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @return
	 */
	public JsonPageData<SysUserDto> queryUser(
			Integer pageNo,
			Integer pageSize,
			String name);

	/**
	 * 添加用户信息
	 * @param e
	 * @return
	 */
	public SysUserEntity addUser(SysUserEntity e);

	/**
	 * 通过ID删除用户信息
	 * @param id
	 */
	public void deleteUser(String id);

	/**
	 * 修改用户信息
	 * @param entity
	 * @return
	 */
	public void updateUser(SysUserEntity entity);

	/**
	 * 查询单个用户信息
	 * @param id
	 * @return
	 */
	public SysUserDto queryUser(String id);

	/**
	 * 通过员工号查询用户的信息
	 * @param userid
	 * @return
	 */
	public SysUserDto queryByUserId(String userid); 
}
