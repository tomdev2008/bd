package com.changhong.bd.products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.products.domain.ProductSimpleTypeDto;
import com.changhong.bd.products.service.api.ProductSimpleTypeService;

/**
 * @author QiYao
 * @date 2014年7月20日
 * @email yao.qi@changhong.com
 * @description 业务商品简单分类 控制器
 *
 */
@Controller
@RequestMapping(value="/Products/ProductSimpleType")
public class ProductSimpleTypeController {

	@Autowired
	private ProductSimpleTypeService productSimpleTypeService;
	
	/**
	 * 列出所有的商品分类
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public JsonData<ProductSimpleTypeDto> query(){
		return this.productSimpleTypeService.query();
	}
}
