package com.changhong.bd.pay.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月6日
 * @version 1.0
 * @description : 微信支付 回调控制器
 */
@Controller
@RequestMapping(value="/pay/wechat/notify")
public class NotifyController {

	@RequestMapping(method=RequestMethod.POST)
	public void notifyPost(){
		
	}
}
