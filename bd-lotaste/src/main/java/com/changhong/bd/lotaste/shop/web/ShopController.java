package com.changhong.bd.lotaste.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.changhong.bd.lotaste.utils.NameUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月23日
 * @version 1.0
 * @description : 多滋味商城首页
 */
@Controller
@RequestMapping(value="/shop")
public class ShopController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(){
		String jsp = NameUtils.EN_NAME + "/shop/index";
		ModelAndView mav = new ModelAndView(jsp);
		return mav;
	}
}
