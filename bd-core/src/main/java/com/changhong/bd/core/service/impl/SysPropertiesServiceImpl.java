package com.changhong.bd.core.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.core.dao.api.SysPropertyDao;
import com.changhong.bd.core.entity.SysPropertyEntity;
import com.changhong.bd.core.service.api.SysPropertiesService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月4日
 * @version 1.0
 * @description : 
 */
@Service("sysPropertiesService")
@Transactional(readOnly=true)
@DependsOn("localSysPropertiesService")
public class SysPropertiesServiceImpl implements SysPropertiesService {

	@Autowired
	private SysPropertyDao sysPropertyDao;
	/**
	 * 属性获取方法： appId.PName -> PValue
	 */
	@PostConstruct
	public void init(){
		List<SysPropertyEntity> list = this.sysPropertyDao.queryAll();
		if(null!=list && list.size()>0){
			for(SysPropertyEntity e : list){
				System.setProperty(e.getAppId() +"."+e.getPropertyName(),e.getPropertyValue());
			}
		}
	}
}
