package com.changhong.bd.products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.products.domain.ProductBusinessDto;
import com.changhong.bd.products.service.api.ProductBusinessService;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 商品信息 控制器 
 *
 */
@Controller
@RequestMapping(value="/Products/ProductBusiness")
public class ProductBusinessController {

	@Autowired
	private ProductBusinessService productBusinessService;
	
	@RequestMapping(method=RequestMethod.GET)
	public JsonPageData<ProductBusinessDto> query(
			@RequestParam(value="pageNo", required=false) Integer pageNo,
			@RequestParam(value="pageSize", required=false) Integer pageSize,
			@RequestParam(value="typeId", required=false) String typeId,
			@RequestParam(value="query", required=false) String query,
			@RequestParam(value="isHot", required=false) Integer isHot){
		
		return this.productBusinessService.query(pageNo, pageSize, typeId, query, isHot);
	}
}
