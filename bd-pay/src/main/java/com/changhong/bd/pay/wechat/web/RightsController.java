package com.changhong.bd.pay.wechat.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.social.utils.WechatXmlUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 微信维权控制器
 */
@Controller
@RequestMapping(value="/pay/wechat/rights")
public class RightsController {

	@RequestMapping(method=RequestMethod.POST, produces=Produces.UTF8)
	@ResponseBody
	public String process(HttpServletRequest request) throws IOException, DocumentException{
		InputStream is = request.getInputStream();
		
		Map<String,String> data = WechatXmlUtils.parseXml(is);
		
		return "success";
	}
}
