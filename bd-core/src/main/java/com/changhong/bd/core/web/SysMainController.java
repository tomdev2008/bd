package com.changhong.bd.core.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.changhong.bd.core.service.BdShiroRealm.ShiroUser;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 管理台 主控制器 
 */
@Controller
@RequestMapping(value="/security")
public class SysMainController {

	/**
	 * 进入控制台主界面
	 * @return
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView indexPage(){
		String jsp = "security/index";
		
		Subject subject = SecurityUtils.getSubject();
		ShiroUser user = (ShiroUser) subject.getSession().getAttribute("currentUser");
		Map<String,Object> datas = new HashMap<String,Object>();
		datas.put("user", user);
		ModelAndView mav = new ModelAndView(jsp, datas);
		return mav;
	}
}
