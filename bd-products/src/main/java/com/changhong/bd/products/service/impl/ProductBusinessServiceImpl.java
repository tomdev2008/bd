package com.changhong.bd.products.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.products.dao.api.ProductBusinessDao;
import com.changhong.bd.products.domain.ProductBusinessDto;
import com.changhong.bd.products.entity.ProductBusiness;
import com.changhong.bd.products.service.api.ProductBusinessService;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
@Service
public class ProductBusinessServiceImpl 
	implements ProductBusinessService{

	@Autowired
	private ProductBusinessDao productBusinessDao;
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.products.service.api.ProductBusinessService#query(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public JsonPageData<ProductBusinessDto> query(
			Integer pageNo,
			Integer pageSize,
			String typeId,
			String query,
			Integer isHot) {
		DetachedCriteria dc = this.productBusinessDao.createDetachedCriteria();
		DetachedCriteria cdc = this.productBusinessDao.createDetachedCriteria();
		
		
		return null;
	}
	
	private List<ProductBusinessDto> transfer(List<ProductBusiness> liste){
		List<ProductBusinessDto> listd = new ArrayList<ProductBusinessDto>();
		
		if(null!=liste && liste.size()>0){
			for(ProductBusiness e : liste){
				ProductBusinessDto d = new ProductBusinessDto();
				BeanUtils.copyProperties(e, d);
				listd.add(d);
			}
		}
		return listd;
	}

}
