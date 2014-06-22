package com.changhong.bd.lotaste.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.changhong.bd.lotaste.utils.NameUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月18日
 * @version 1.0
 * @description : 默认控制器
 */
@Controller
@RequestMapping(value="/")
public class IndexController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(){
		String jsp = NameUtils.getEnName() + "/index";
		ModelAndView mav = new ModelAndView(jsp);
		return mav;
	}
}
