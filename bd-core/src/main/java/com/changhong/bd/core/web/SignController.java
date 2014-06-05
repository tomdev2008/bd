package com.changhong.bd.core.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.changhong.bd.core.resp.JsonMessage;
import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.core.service.api.SysAccountService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月10日
 * @version 1.0
 * @description : 登陆/退出 - 控制器
 */
@Controller
@RequestMapping(value="/security")
public class SignController {

	@Autowired
	private SysAccountService sysAccountService;
	/**
	 * 进入登陆页面
	 * @return
	 */
	@RequestMapping(value="signIn", method=RequestMethod.GET)
	public ModelAndView signInPage(){
		String jsp = "security/signIn";
		ModelAndView mav = new ModelAndView(jsp);
		return mav;
	}
	
	/**
	 * 执行ajax登陆操作
	 * @return
	 */
	@RequestMapping(value="signIn", method=RequestMethod.POST, produces="application/json; charset=utf-8")
	@ResponseBody
	public JsonMessage signIn(
			@RequestParam(value="account") String account,
			@RequestParam(value="password") String password){
		UsernamePasswordToken token = new UsernamePasswordToken( account, password );
		
		//记住我
		token.setRememberMe(false);
		
		JsonMessage jm = new JsonMessage();
		jm.setMessage("出错");
		//执行登陆操作
		Subject currentUser = SecurityUtils.getSubject();
		try {
		    currentUser.login(token);
		    //SysAccountEntity sysAccount =  this.sysAccountService.queryUserByLoginName(account);
		    //该社交账户已经绑定的信息, 如果存在，就先删除了
			jm.setMessage("success");
		} catch ( UnknownAccountException uae ) {
			uae.printStackTrace();
			jm.setMessage("账户不存在");
		} catch ( IncorrectCredentialsException ice ) {
			ice.printStackTrace();
			jm.setMessage("密码错误");
		} catch ( LockedAccountException lae ) { 
			lae.printStackTrace();
			jm.setMessage("账户已被锁定");
		} catch ( ExcessiveAttemptsException eae ) { 
			eae.printStackTrace();
			jm.setMessage("尝试次数过多");
		}
		
		
		return jm;
	}
	/**
	 * ajax 登出操作
	 * @return
	 */
	@RequestMapping(value="signOut", method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public JsonMessage signOut(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		
		JsonMessage jm = new JsonMessage(200, "sucess");
		return jm;
	}
}
