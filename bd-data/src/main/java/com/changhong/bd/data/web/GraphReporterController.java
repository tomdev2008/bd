package com.changhong.bd.data.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.data.domain.DataReporterDto;
import com.changhong.bd.data.service.api.DataReporterService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月11日
 * @version 1.0
 * @description : 图形报表控制器
 */
@Controller
@RequestMapping(value="/data/graphreporter")
public class GraphReporterController {

	@Autowired
	private DataReporterService dataReporterService;
	/**
	 * 查询所有的报表
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces=Produces.JSON_STRING)
	@ResponseBody
	public JsonData<DataReporterDto> query(){
		return this.dataReporterService.query();
	}
}
