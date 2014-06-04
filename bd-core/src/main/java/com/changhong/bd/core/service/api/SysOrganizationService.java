package com.changhong.bd.core.service.api;

import com.changhong.bd.core.entity.SysOrganizationEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 组织结构服务api
 */
public interface SysOrganizationService {

	/**
	 * 新增组织机构
	 * @param entity
	 */
	public void saveOrg(SysOrganizationEntity entity);

	/**
	 * 删除组织架构
	 * @param id
	 */
	void deleteOrg(String id);
}
