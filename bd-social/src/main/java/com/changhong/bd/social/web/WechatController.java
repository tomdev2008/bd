package com.changhong.bd.social.web;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.social.service.api.WechatService;
import com.changhong.bd.social.utils.WechatSignUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 微信控制器
 */
@Controller
@RequestMapping(value="/social/wechat")
public class WechatController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("wechatService")
	private WechatService wechatService;
	/**
	 * 微信信息入口, GET 类型，认证信息
	 */
	@RequestMapping(value="msg", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public String in(
			@RequestParam(value="signature") String signature,
			@RequestParam(value="timestamp") String timestamp,
			@RequestParam(value="nonce") String nonce,
			@RequestParam(value="echostr") String echostr){
		
		logger.info("signature:"+signature);
		logger.info("timestamp:"+timestamp);
		logger.info("nonce:"+nonce);
		logger.info("echostr:"+echostr);
		
		if(WechatSignUtils.checkSignature(signature, timestamp, nonce)){
			logger.info("wechat validated success");
			return echostr;
		}else{
			logger.info("wechat validated fail");
			return "";
		}
	}
	/**
	 * 处理微信信息
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	@RequestMapping(value="msg", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public String messageIn(
			@RequestParam(value="signature") String signature,
			@RequestParam(value="timestamp") String timestamp,
			@RequestParam(value="nonce") String nonce,
			HttpServletRequest request) throws DocumentException, IOException{
		
		logger.info("msg in 2");
		// 将解析结果存储在HashMap中
		if(WechatSignUtils.checkSignature(signature, timestamp, nonce)){
			InputStream is = request.getInputStream();
			String msg = this.wechatService.process(is);
			return msg;
		}else{
			logger.info("wechat validate fail");
			return "";
		}
	}
}
