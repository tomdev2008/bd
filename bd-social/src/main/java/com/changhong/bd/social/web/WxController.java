package com.changhong.bd.social.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
@Controller
@RequestMapping(value="/wx")
public class WxController {


	@RequestMapping(value="getPage", method=RequestMethod.GET)
	public String page(){
		return "openlink/index";
	}
	

	@RequestMapping(value="allPage")
	public String allPage(){
		return "openlink/index";
	}
}
