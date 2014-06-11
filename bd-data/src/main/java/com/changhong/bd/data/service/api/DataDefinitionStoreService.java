package com.changhong.bd.data.service.api;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.data.domain.RepositoryDto;
import com.changhong.bd.data.entity.DataRepositoryEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 数据定义仓库服务
 */
public interface DataDefinitionStoreService {
	
	/**
	 * 获取所有的数据仓库信息
	 * @return
	 */
	public JsonData<RepositoryDto> queryAllRepository(String name);
	
	/**
	 * 通过ID查询仓库定义
	 * @param id
	 * @return
	 */
	public DataRepositoryEntity query(String id);
}
