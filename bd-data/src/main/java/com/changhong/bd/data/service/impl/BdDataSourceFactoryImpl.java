package com.changhong.bd.data.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.changhong.bd.data.entity.RepositoryEntity;
import com.changhong.bd.data.service.api.BdDataSourceFactory;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月20日
 * @version 1.0
 * @description : 数据源连接工厂
 */
@Service("bdDataSourceFactory")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BdDataSourceFactoryImpl implements BdDataSourceFactory {
	//数据源池 key 仓库ID
	private static Map<String, DriverManagerDataSource> dsPool = Collections.synchronizedMap(new HashMap<String, DriverManagerDataSource>());
	
	private static Logger logger = LoggerFactory.getLogger(BdDataSourceFactoryImpl.class);
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.data.service.impl.BdDataSourceFactory#getDataSource(com.changhong.bd.data.entity.RepositoryEntity)
	 */
	@Override
	public DataSource queryDataSource(RepositoryEntity entity){
		DriverManagerDataSource ds = dsPool.get(entity.getId());
		if(null == ds){
			String key = entity.getId();
			//load driver
			String driver = entity.getDriver();
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error("load driver {} fail.", driver);
			}
			
			String url = entity.getUrl();
			String username = entity.getUsername();
			String password = entity.getPassword();
			ds = new DriverManagerDataSource(url, username, password);
			dsPool.put(key, ds);
		}
		return ds;
	}
	/* (non-Javadoc)
	 * @see com.changhong.bd.data.service.impl.BdDataSourceFactory#getCollection(com.changhong.bd.data.entity.RepositoryEntity)
	 */
	@Override
	public Connection queryCollection(RepositoryEntity entity){
		DataSource ds = this.queryDataSource(entity);
		Connection conn = null;
		String key = entity.getId();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("get db connection {} fail", key);
		}
		return conn;
	}
	@Override
	public Statement queryStatement(RepositoryEntity entity) throws SQLException {
		Connection conn = this.queryCollection(entity);
		Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		return statement;
	}
}
