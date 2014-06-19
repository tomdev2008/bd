package com.changhong.bd.loteste.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		String jsp = "loteste/index";
		ModelAndView mav = new ModelAndView(jsp);
		return mav;
	}
}
