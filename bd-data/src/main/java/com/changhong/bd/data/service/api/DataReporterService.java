package com.changhong.bd.data.service.api;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.data.domain.DataReporterDto;
import com.changhong.bd.data.entity.DataReporterEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月11日
 * @version 1.0
 * @description : 
 */
public interface DataReporterService {

	/**
	 * 查询全部报表
	 * @return
	 */
	public JsonData<DataReporterDto> query();
	/**
	 * 查询单个报表
	 * @param id
	 * @return
	 */
	public DataReporterDto query(String id);
	/**
	 * 新增报表
	 * @param e
	 * @return
	 */
	public DataReporterDto add(DataReporterEntity e);
	/**
	 * 删除报表
	 * @param id
	 */
	public void delete(String id);
}
