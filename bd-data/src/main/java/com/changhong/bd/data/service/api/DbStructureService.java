package com.changhong.bd.data.service.api;

import java.sql.SQLException;
import java.util.List;

import com.changhong.bd.data.domain.DataElementDto;
import com.changhong.bd.data.domain.DbTableDto;
import com.changhong.bd.data.domain.TableColumnDto;
import com.changhong.bd.data.entity.DataElementGroupEntity;
import com.changhong.bd.data.entity.RepositoryEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 数据库 视图 服务
 */
public interface DbStructureService {

	/**
	 * 获取仓库下的所有 表和视图定义
	 * @param rep
	 * @return
	 * @throws SQLException
	 */
	public List<DbTableDto> queryAllIndex(RepositoryEntity rep) throws SQLException;
	
	/**
	 * 查询表的字段
	 * @param table
	 * @return
	 */
	public List<TableColumnDto> queryColumns(DbTableDto table);
	/**
	 * 通过仓库ID，表名查询列定义信息
	 * @param rep
	 * @param tableName
	 * @return
	 * @throws SQLException 
	 */
	public List<TableColumnDto> queryColumns(RepositoryEntity rep, String tableName) throws SQLException;

	/**
	 * 获取数据集的数据元素
	 * @param group
	 * @return
	 * @throws SQLException
	 */
	public List<DataElementDto> queryDateElement(DataElementGroupEntity group) throws SQLException;
}
