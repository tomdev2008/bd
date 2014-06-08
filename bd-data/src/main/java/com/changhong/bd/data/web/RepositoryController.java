package com.changhong.bd.data.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.data.domain.DbTableDto;
import com.changhong.bd.data.domain.RepositoryDto;
import com.changhong.bd.data.domain.TableColumnDto;
import com.changhong.bd.data.entity.RepositoryEntity;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;
import com.changhong.bd.data.service.api.DbStructureService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月3日
 * @version 1.0
 * @description : 数据仓库控制器 
 */
@Controller
@RequestMapping(value="/data/repository")
public class RepositoryController {

	@Autowired
	private DataDefinitionStoreService dataDefinitionStoreService;
	
	@Autowired
	private DbStructureService dbStructureService;
	
	/**
	 * 查询全部的数据仓库定义
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public JsonData<RepositoryDto> query(){
		return dataDefinitionStoreService.queryAllRepository("");
	}
	
	/**
	 * 查询仓库详细信息
	 * @throws SQLException 
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public List<DbTableDto> queryTableInfo(@PathVariable(value="id") String id) throws SQLException{
		RepositoryEntity re = this.dataDefinitionStoreService.query(id);
		if(re == null){
			return null;
		}else{
			List<DbTableDto> list = this.dbStructureService.queryAllIndex(re);
			return list;
		}
	}
	/**
	 * 通过table 名  和 仓库id查询列信息
	 * @throws SQLException 
	 */
	@RequestMapping(value="/{id}/{tableName}", method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public List<TableColumnDto> queryTableColumns(
			@PathVariable(value="id") String id,
			@PathVariable(value="tableName") String tableName
			) throws SQLException{
		
		RepositoryEntity rep = this.dataDefinitionStoreService.query(id);
		List<TableColumnDto> cols = dbStructureService.queryColumns(rep , tableName);
		
		return cols;
	}
}
