package com.changhong.bd.pay.wechat.service.api;

import com.changhong.bd.pay.domain.PayRequestDto;
import com.changhong.bd.pay.entity.PayRequestEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 微信支付服务 api接口
 */
public interface WechatPayService {

	/**
	 * 增加微信支付请求
	 * @param entity
	 * @return
	 */
	public PayRequestDto addPayRequest(PayRequestEntity entity);
	/**
	 * 已经创建了支付请求，通过支付ID进行支付
	 * @param payId
	 * @return
	 */
	public PayRequestDto addPayRequest(String payId);

}
