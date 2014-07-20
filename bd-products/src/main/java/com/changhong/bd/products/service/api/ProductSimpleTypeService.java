package com.changhong.bd.products.service.api;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.products.domain.ProductSimpleTypeDto;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public interface ProductSimpleTypeService {

	/**
	 * 查询所有的分类
	 * @return
	 */
	public JsonData<ProductSimpleTypeDto> query();
}
