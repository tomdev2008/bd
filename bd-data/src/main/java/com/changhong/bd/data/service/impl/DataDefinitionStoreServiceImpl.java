package com.changhong.bd.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.data.dao.api.RepositoryEntityDao;
import com.changhong.bd.data.domain.RepositoryDto;
import com.changhong.bd.data.entity.RepositoryEntity;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 
 */
@Service("dataDefinitionStoreService")
@Transactional(readOnly=true)
public class DataDefinitionStoreServiceImpl implements DataDefinitionStoreService {

	@Autowired
	private RepositoryEntityDao repositoryEntityDao;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public JsonData<RepositoryDto> queryAllRepository(String name) {
		DetachedCriteria criteria = this.repositoryEntityDao.createDetachedCriteria();
		
		if(StringUtils.isNotEmpty(name)){
			criteria.add(Restrictions.eq("name", name));
		}
		
		criteria.addOrder(Order.desc("name"));
		List<RepositoryEntity> liste = this.repositoryEntityDao.queryByCriteria(criteria );
		Long count = this.repositoryEntityDao.queryRowCount(criteria);
		
		List<RepositoryDto> listd = new ArrayList<RepositoryDto>();
		if(liste != null && liste.size()>0){
			for(RepositoryEntity e:liste){
				listd.add(modelMapper.map(e, RepositoryDto.class));
			}
		}
		
		JsonData<RepositoryDto> jd = new JsonData<RepositoryDto>(count, listd);
		return jd;
	}

	@Override
	public RepositoryEntity query(String id) {
		return this.repositoryEntityDao.query(id);
	}

}
