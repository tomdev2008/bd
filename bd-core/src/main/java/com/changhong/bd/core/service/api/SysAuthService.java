package com.changhong.bd.core.service.api;

import com.changhong.bd.core.domain.SysAuthMenuCatalogDto;
import com.changhong.bd.core.entity.SysAuthButtonEntity;
import com.changhong.bd.core.entity.SysAuthButtonCatalogEntity;
import com.changhong.bd.core.resp.JsonData;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 系统权限认证服务
 */
public interface SysAuthService {

	/**
	 * 添加按钮权限
	 * @param btn
	 */
	public void addAuthBtn(SysAuthButtonEntity btn);
	/**
	 * 修改按钮权限
	 */
	public void updateAuthBtn(SysAuthButtonEntity btn);
	/**
	 * 添加权限目录
	 * @param btnCatalog
	 */
	public void addAuthBtnCatalog(SysAuthButtonCatalogEntity btnCatalog);
	/**
	 * 修改按钮权限目录
	 * @param btnCatalog
	 */
	public void updateAuthBtnCatalog(SysAuthButtonCatalogEntity btnCatalog);
	/**
	 * 删除按钮权限
	 * @param id
	 */
	public void deleteAuthBtn(String id);
	/**
	 * 删除按钮权限目录
	 * @param id
	 */
	public void deleteAuthCatalog(String id);
	
	/**
	 * 查询所有的菜单信息树
	 * @return
	 */
	public JsonData<SysAuthMenuCatalogDto> queryAllMenuCatalog();
	
}
