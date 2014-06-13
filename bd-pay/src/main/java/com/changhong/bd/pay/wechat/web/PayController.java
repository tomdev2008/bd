package com.changhong.bd.pay.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.pay.domain.PayRequestDto;
import com.changhong.bd.pay.entity.PayRequestEntity;
import com.changhong.bd.pay.wechat.service.api.WechatPayService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月12日
 * @version 1.0
 * @description : 生成js信息的控制器
 */
@Controller
@RequestMapping(value="/pay/wechat")
public class PayController {

	private WechatPayService wechatPayService;
	
	/**
	 * 创建微信js支付请求，并传递相关的数据过来
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/js", method=RequestMethod.POST, produces=Produces.JSON_STRING)
	@ResponseBody
	public PayRequestDto createJsPay(PayRequestEntity entity){
		return this.wechatPayService.addPayRequest(entity);
	}
	
	/**
	 * 对指定的payId 创建支付请求
	 * @param reqId
	 * @return
	 */
	@RequestMapping(value="/js/{payId}", method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public PayRequestDto createJsPay(
			@PathVariable(value="payId") String reqId){
		
		return this.wechatPayService.addPayRequest(reqId);
	}
}
