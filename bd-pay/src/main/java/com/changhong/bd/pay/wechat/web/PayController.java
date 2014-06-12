package com.changhong.bd.pay.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.JsonMessage;
import com.changhong.bd.core.resp.Produces;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月12日
 * @version 1.0
 * @description : 生成js信息的控制器
 */
@Controller
@RequestMapping(value="/pay/wechat")
public class PayController {

	
	@RequestMapping(value="/js", method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public JsonMessage jsApi(){
		String message = "";
		JsonMessage jm = new JsonMessage(200, message);
		return jm;
	}
}
