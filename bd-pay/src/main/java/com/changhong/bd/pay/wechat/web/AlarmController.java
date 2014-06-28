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
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.pay.entity.WechatAlarmEntity;
import com.changhong.bd.pay.wechat.service.api.WechatAlarmService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 微信告警控制器 
 */
@Controller
@RequestMapping(value="/pay/wechat/alarm")
public class AlarmController {

	@Autowired
	private WechatAlarmService wechatAlarmService;
	
	@RequestMapping(method=RequestMethod.POST, produces=Produces.UTF8)
	@ResponseBody
	public String process(HttpServletRequest request) throws IOException, DocumentException{
		InputStream is = request.getInputStream();
		//TODO
		Map<String,String> data = null;//WechatXmlUtils.parseXml(is);
		
		WechatAlarmEntity e = new WechatAlarmEntity();
	    
	    e.setAppId(data.get("AppId"));
	    e.setErrorType(data.get("ErrorType"));
	    e.setDescription(data.get("Description"));
	    e.setAlarmContent(data.get("AlarmContent"));
	    e.setTimeStamp(data.get("TimeStamp"));
	    e.setAppSignature(data.get("AppSignature"));
	    e.setSignMethod(data.get("SignMethod"));
	    
	    this.wechatAlarmService.add(e);
	    
		return "success";
	}
}
