package com.changhong.bd.mingwang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月6日
 * @version 1.0
 * @description : 铭旺支付控制器
 */
@Controller
@RequestMapping(value="/mingwang/pay")
public class PayController {

	/**
	 * 进入支付页面
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView page(){
		String jsp = "mingwang/pay/page";
		ModelAndView mav = new ModelAndView(jsp);
		return mav;
	}
}
