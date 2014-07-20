package com.changhong.bd.products.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.products.dao.api.ProductSimpleTypeDao;
import com.changhong.bd.products.domain.ProductSimpleTypeDto;
import com.changhong.bd.products.entity.ProductSimpleType;
import com.changhong.bd.products.service.api.ProductSimpleTypeService;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Service
public class ProductSimpleTypeServiceImpl implements ProductSimpleTypeService{

	@Autowired
	private ProductSimpleTypeDao productSimpleTypeServiceDao;
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.products.service.api.ProductSimpleTypeService#query()
	 */
	@Override
	public JsonData<ProductSimpleTypeDto> query() {
		DetachedCriteria dc = this.productSimpleTypeServiceDao.createDetachedCriteria();
		
		dc.addOrder(Order.desc("priority"));
		List<ProductSimpleType> liste = this.productSimpleTypeServiceDao.queryByCriteria(dc);
		List<ProductSimpleTypeDto> list = this.transfer(liste);
		
		Long count = this.productSimpleTypeServiceDao.queryRowCount();
		
		JsonData<ProductSimpleTypeDto> jd = new JsonData<ProductSimpleTypeDto>(count, list);
		
		return jd;
	}

	private List<ProductSimpleTypeDto> transfer(List<ProductSimpleType> liste){
		List<ProductSimpleTypeDto> listd = new ArrayList<ProductSimpleTypeDto>();
		if(null!=liste && liste.size()>0){
			for(ProductSimpleType t : liste){
				ProductSimpleTypeDto d = new ProductSimpleTypeDto();
				BeanUtils.copyProperties(t, d);
				listd.add(d);
			}
		}
		return listd;
	}
}
