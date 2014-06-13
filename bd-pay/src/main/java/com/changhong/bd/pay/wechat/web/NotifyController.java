package com.changhong.bd.pay.wechat.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.pay.wechat.service.api.WechatPayService;
import com.changhong.bd.social.utils.WechatXmlUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月6日
 * @version 1.0
 * @description : 微信支付 回调控制器
 */
@Controller
@RequestMapping(value="/pay/wechat/notify")
public class NotifyController {

	@Autowired
	private WechatPayService wechatPayService;
	
	@RequestMapping(method=RequestMethod.POST, produces=Produces.UTF8)
	@ResponseBody
	public String notifyPost(
			@RequestParam(value="sign_type", required=false, defaultValue="MD5") String signType,
			@RequestParam(value="service_version", required=false, defaultValue="1.0") String serviceVersion,
			@RequestParam(value="input_charset", required=false, defaultValue="GBK") String inputCharset,
			@RequestParam(value="sign") String sign,
			@RequestParam(value="sign_key_index", required=false, defaultValue="1") Integer signKeyIndex,
			//business
			@RequestParam(value="trade_mode") Integer tradeMode, //交易模式
			@RequestParam(value="trade_state") Integer tradeState,//交易状态
			@RequestParam(value="pay_info", required=false, defaultValue="") String payInfo,//支付结果信息
			@RequestParam(value="partner") String partner,//商户号
			@RequestParam(value="bank_type") String bankType,//付款银行
			@RequestParam(value="bank_tillno", required=false, defaultValue="") String bankTillNo,//银行订单号
			@RequestParam(value="total_fee") Integer totalFee ,//总金额
			@RequestParam(value="fee_type") Integer feeType,//币种
			@RequestParam(value="notify_id") String notifyId,//通知ID
			@RequestParam(value="transaction_id") String transactionId,//订单号
			@RequestParam(value="out_trade_no") String outTradeNo,//商户订单号
			@RequestParam(value="attach",required=false, defaultValue="") String attach,//商户数据包
			@RequestParam(value="time_end") String timeEnd,//支付完成时间
			@RequestParam(value="transport_fee", required=false, defaultValue="0") Integer transportFee ,//物流费用
			@RequestParam(value="product_fee", required=false, defaultValue="0") Integer productFee,//产品费用
			@RequestParam(value="discount", required=false, defaultValue="0") Integer discount,//折扣价格
			@RequestParam(value="buyer_alias", required=false, defaultValue="") String buyerAlias,//买家别名
			HttpServletRequest request) throws IOException, DocumentException{
		InputStream is = request.getInputStream();
		
		Map<String,String> data = WechatXmlUtils.parseXml(is);
		//TODO
		
		return "success";
	}
}
