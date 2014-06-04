package com.changhong.bd.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.domain.SysRegionDto;
import com.changhong.bd.core.service.api.SysRegionService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月26日
 * @version 1.0
 * @description : 地区REST控制器
 */
@Controller
@RequestMapping(value="/sys/region")
public class SysRegionController {
	
	@Autowired
	private SysRegionService sysRegionService;
	
	/**
	 * 查询区域树
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public SysRegionDto queryTree(){
		return this.sysRegionService.querySysRegionTree();
	}
}
