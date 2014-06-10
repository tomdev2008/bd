package com.changhong.bd.data.service.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.data.dao.api.DataElementDao;
import com.changhong.bd.data.dao.api.DataElementGroupDao;
import com.changhong.bd.data.domain.DataElementGroupDto;
import com.changhong.bd.data.entity.DataElementEntity;
import com.changhong.bd.data.entity.DataElementGroupEntity;
import com.changhong.bd.data.entity.RepositoryEntity;
import com.changhong.bd.data.service.api.BdDataSourceFactory;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;
import com.changhong.bd.data.service.api.DataElementService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月9日
 * @version 1.0
 * @description : 
 */
@Service("dataElementService")
@Transactional(readOnly=true)
public class DataElementServiceImpl implements DataElementService {

	@Autowired
	private DataElementGroupDao dataElementGroupDao;
	@Autowired
	private DataElementDao dataElementDao;
	@Autowired
	private DataDefinitionStoreService dataDefinitionStoreService;
	@Autowired
	private BdDataSourceFactory bdDataSourceFactory;
	@Override
	public List<DataElementGroupDto> query(String repId) {
		DetachedCriteria dc = this.dataElementGroupDao.createDetachedCriteria();
		
		RepositoryEntity rep = new RepositoryEntity();
		rep.setId(repId);
		
		dc.add(Restrictions.eq("rep", rep));
		dc.addOrder(Order.asc("name"));
		
		List<DataElementGroupEntity> list = this.dataElementGroupDao.queryByCriteria(dc);
		List<DataElementGroupDto> dtos = new ArrayList<DataElementGroupDto>();
		
		if(null!=list){
			for(DataElementGroupEntity e : list){
				dtos.add(new DataElementGroupDto(e));
			}
		}
		
		return dtos;
	}

	@Override
	@Transactional(readOnly=false)
	public DataElementGroupEntity addSqlDataElement(String name, String sql, String repId) throws SQLException{
		RepositoryEntity rep = this.dataDefinitionStoreService.query(repId);
		Statement statement = this.bdDataSourceFactory.queryStatement(rep);
		ResultSet rs = statement.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int size = rsmd.getColumnCount();
		
		DataElementGroupEntity group = new DataElementGroupEntity();
		group.setName(name);
		group.setProcessLanguage(sql);
		group.setRep(rep);
		
		List<DataElementEntity> liste = new ArrayList<DataElementEntity>();
		for(int i=1;i<=size;i++){
			String columnClassName = rsmd.getColumnClassName(i);
			Integer columnDisplaySize = rsmd.getColumnDisplaySize(i);
			String columnLabel = rsmd.getColumnLabel(i);
			String columnName = rsmd.getColumnName(i);
			Integer columnType = rsmd.getColumnType(i);
			String columnTypeName = rsmd.getColumnTypeName(i);
			Integer precision = rsmd.getPrecision(i);
			Integer scale = rsmd.getScale(i);
			String tableSchema = rsmd.getSchemaName(i);
			String tableName = rsmd.getTableName(i);
			
			DataElementEntity e = new DataElementEntity();
			e.setGroup(group);
			e.setColumnClassName(columnClassName);
			e.setColumnDisplaySize(columnDisplaySize);
			e.setColumnLabel(columnLabel);
			e.setColumnName(columnName);
			e.setColumnType(columnType);
			e.setColumnTypeName(columnTypeName);
			e.setPrecision(precision);
			e.setScale(scale);
			e.setTableName(tableName);
			e.setTableSchema(tableSchema);
			
			liste.add(e);
		}
		group.setDataElements(liste);
		
		return this.dataElementGroupDao.save(group);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteSqlDataElement(String id) {
		DataElementGroupEntity group = this.dataElementGroupDao.query(id);
		List<DataElementEntity> eles = group.getDataElements();
		if(null!=eles && eles.size()>0){
			for(DataElementEntity e : eles){
				this.dataElementDao.deleteByKey(e.getId());
			}
		}
		this.dataElementGroupDao.deleteByKey(id);
	}

}
