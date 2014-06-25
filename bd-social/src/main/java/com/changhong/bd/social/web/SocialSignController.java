package com.changhong.bd.social.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.naming.AuthenticationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.resp.JsonMessage;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.core.utils.DateUtils;
import com.changhong.bd.email.service.api.MailService;
import com.changhong.bd.social.entity.SocialBindEntity;
import com.changhong.bd.social.service.api.SocialService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 社交登陆控制器
 */
@Controller
@RequestMapping(value="/social/sign")
public class SocialSignController {

	@Autowired
	@Qualifier("socialService")
	private SocialService socialService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private SysAccountService sysAccountService;
	
	/**
	 * 进入社交登陆页面, 需要参数：
	 * @param socialType 社交类型
	 * @param socialId 对应社交类型的OpenId
	 * @return
	 */
	@RequestMapping(value="/in", method=RequestMethod.GET)
	public ModelAndView signInPage(
			@RequestParam(value="socialType") String socialType,
			@RequestParam(value="socialId") String socialId){
		String jsp = "social/signIn";
		
		Map<String,Object> data = new HashMap<String,Object>();
		
		data.put("socialType", socialType);
		data.put("socialId", socialId);
		
		ModelAndView mav = new ModelAndView(jsp, data);
		
		return mav;
	}
	/**
	 * 提交登陆数据 TODO
	 * @param socialType
	 * @param socialId
	 * @param account
	 * @param password
	 * @return
	 * @throws MessagingException 
	 */
	@RequestMapping(value="/in", method=RequestMethod.POST, produces="application/json; charset=utf-8")
	@ResponseBody
	public JsonMessage signIn(
			@RequestParam(value="socialType") String socialType,
			@RequestParam(value="socialId") String socialId,
			@RequestParam(value="account") String account,
			@RequestParam(value="password") String password,
			@RequestParam(value="remenber", required=false, defaultValue="no") String remenber) throws AuthenticationException, MessagingException{

		//TODO validate password match account;
		UsernamePasswordToken token = new UsernamePasswordToken( account, password );
		
		//记住我
		if("yes".equals(remenber)){
			token.setRememberMe(true);
		}
		JsonMessage jm = new JsonMessage();
		jm.setMessage("登陆失败");
		//执行登陆操作
		Subject currentUser = SecurityUtils.getSubject();
		try {
		    currentUser.login(token);
		    SysAccountEntity sysAccount =  this.sysAccountService.queryUserByLoginName(account);
		    
		    //该社交账户已经绑定的信息, 如果存在，就先删除了
			List<SocialBindEntity> blist = this.socialService.queryByOpenId(socialType, socialId);
			if(null!=blist && blist.size()>0){
				
				for(SocialBindEntity bind : blist){
					this.socialService.deleteLink(bind);
				}
			}
			this.socialService.addLink(sysAccount.getId(), socialType, socialId);
			
			String dateString = DateUtils.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss");
			String mailContent = dateString+",你的账户绑定了微信。";
			
			SysAccountDto dto = this.sysAccountService.queryById(sysAccount.getId());
			this.mailService.send("微信绑定提醒(自动信息，请勿回复)", dto.getUserEmail(), mailContent);
			
			jm.setMessage("新绑定已经生效");
		} catch ( UnknownAccountException uae ) {
			uae.printStackTrace();
		} catch ( IncorrectCredentialsException ice ) {
			ice.printStackTrace();
		} catch ( LockedAccountException lae ) { 
			lae.printStackTrace();
		} catch ( ExcessiveAttemptsException eae ) { 
			eae.printStackTrace();
		}
		
		
		return jm;
	}
}
