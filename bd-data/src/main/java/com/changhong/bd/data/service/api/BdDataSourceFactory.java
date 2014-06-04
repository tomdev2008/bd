package com.changhong.bd.data.service.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.changhong.bd.data.entity.RepositoryEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 数据连接池 工厂类
 */
public interface BdDataSourceFactory {

	/**
	 * 获取数据源
	 * @param entity
	 * @throws  
	 */
	public abstract DataSource queryDataSource(RepositoryEntity entity);

	/**
	 * 获取数据库连接
	 * @param entity
	 * @return
	 */
	public abstract Connection queryCollection(RepositoryEntity entity);

	/**
	 * 获取statement
	 * @param entity
	 * @return
	 * @throws SQLException 
	 */
	public abstract Statement queryStatement(RepositoryEntity entity) throws SQLException;
}