package com.changhong.bd.core.service.api;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.resp.JsonPageData;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 
 */
public interface SysAccountService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	public static final String SALT = "Tony";

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public SysAccountEntity queryUserByLoginName(String username);

	/**
	 * 添加系统账户
	 * @param entity
	 * @return
	 */
	public SysAccountEntity addAccount(SysAccountEntity entity);

	/**
	 * 通过ID查询账户
	 * @param id
	 */
	public SysAccountDto queryById(String id);

	/**
	 * 分页查询用户信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public JsonPageData<SysAccountDto> query(Integer pageNo, Integer pageSize);

	/**
	 * 通过员工ID查询操作用户
	 * @param userid
	 * @return
	 */
	public SysAccountDto queryByUserId(String userid);

	

}
