package com.changhong.bd.products.service.api;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.products.domain.ProductBusinessDto;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public interface ProductBusinessService {

	/**
	 * 查询分页信息
	 * @param pageNo
	 * @param pageSize
	 * @param typeId
	 * @param query
	 * @param isHot
	 * @return
	 */
	JsonPageData<ProductBusinessDto> query(Integer pageNo, Integer pageSize,
			String typeId, String query, Integer isHot);

}
