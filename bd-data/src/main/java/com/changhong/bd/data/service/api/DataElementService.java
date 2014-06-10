package com.changhong.bd.data.service.api;

import java.sql.SQLException;
import java.util.List;

import com.changhong.bd.data.domain.DataElementGroupDto;
import com.changhong.bd.data.entity.DataElementGroupEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月9日
 * @version 1.0
 * @description : 数据元素服务接口
 */
public interface DataElementService {

	/**
	 * 查询数据仓库下的所有数据集
	 * @param repId
	 * @return
	 */
	public List<DataElementGroupDto> query(String repId);
	/**
	 * 新增数据集元素
	 * @param e
	 * @return
	 * @throws SQLException 
	 */
	public DataElementGroupEntity addSqlDataElement(String name, String sql, String repId) throws SQLException;
	/**
	 * 删除sql数据元素集
	 * @param id
	 */
	public void deleteSqlDataElement(String id);
}
