package com.changhong.bd.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.domain.SysAuthMenuCatalogDto;
import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.core.service.api.SysAuthService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 系统认证控制器
 */
@Controller
@RequestMapping(value="/sys/menu")
public class SysAuthController {

	@Autowired
	private SysAuthService sysAuthService;
	/**
	 * 查询用户的菜单信息  TODO 直接给全部菜单
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public JsonData<SysAuthMenuCatalogDto> queryUserMenus(){
		JsonData<SysAuthMenuCatalogDto> jd = this.sysAuthService.queryAllMenuCatalog();
		return jd;
	}
}
