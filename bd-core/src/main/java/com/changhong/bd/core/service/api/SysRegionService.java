package com.changhong.bd.core.service.api;

import com.changhong.bd.core.domain.SysRegionDto;
import com.changhong.bd.core.entity.SysRegionEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 地区服务接口
 */
public interface SysRegionService {

	/**
	 * 查询区域树
	 * @return
	 */
	public SysRegionDto querySysRegionTree();
	/**
	 * 添加区域
	 * @param entity
	 * @return
	 */
	public SysRegionEntity addSysRegion(SysRegionEntity entity);
	/**
	 * 删除区域
	 * @param id
	 */
	public void deleteSysRegion(String id);
}
