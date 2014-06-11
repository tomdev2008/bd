package com.changhong.bd.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.data.dao.api.DataReporterDao;
import com.changhong.bd.data.domain.DataReporterDto;
import com.changhong.bd.data.entity.DataReporterEntity;
import com.changhong.bd.data.service.api.DataReporterService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月11日
 * @version 1.0
 * @description : 
 */
@Service("dataReporterService")
@Transactional(readOnly=true)
public class DataReporterServiceImpl implements DataReporterService {

	@Autowired
	private DataReporterDao dataReporterDao;
	
	@Override
	public JsonData<DataReporterDto> query() {
		List<DataReporterEntity> list = this.dataReporterDao.queryAll();
		Long count = this.dataReporterDao.queryRowCount();
		
		List<DataReporterDto> listd = this.transfer(list);
		
		JsonData<DataReporterDto> jd = new JsonData<DataReporterDto>(count, listd);
		return jd;
	}
	public DataReporterDto transfer(DataReporterEntity e){
		return new DataReporterDto(e);
	}
	public List<DataReporterDto> transfer(List<DataReporterEntity> list){
		List<DataReporterDto> listd = new ArrayList<DataReporterDto>();
		if(null!=list && list.size()>0){
			for(DataReporterEntity e : list){
				listd.add(this.transfer(e));
			}
		}
		return listd;
	}

	@Override
	public DataReporterDto query(String id) {
		DataReporterEntity e = this.dataReporterDao.query(id);
		return this.transfer(e);
	}

	@Override
	@Transactional(readOnly=false)
	public DataReporterDto add(DataReporterEntity e) {
		DataReporterEntity pe = this.dataReporterDao.save(e); 
		return this.transfer(pe);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void delete(String id) {
		this.dataReporterDao.deleteByKey(id);		
	}

}
