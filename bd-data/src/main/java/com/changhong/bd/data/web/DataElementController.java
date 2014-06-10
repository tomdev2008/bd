package com.changhong.bd.data.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.changhong.bd.core.resp.Produces;
import com.changhong.bd.data.domain.DataElementGroupDto;
import com.changhong.bd.data.service.api.DataElementService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月9日
 * @version 1.0
 * @description : 数据元素控制器
 */
@Controller
@RequestMapping(value="/data/dataelement")
public class DataElementController {

	private DataElementService dataElementService;
	@RequestMapping(value="/{repId}",method=RequestMethod.GET, produces=Produces.JSON_STRING)
	public List<DataElementGroupDto> query(@PathVariable(value="repId") String repId){
		return this.dataElementService.query(repId);
	}
}
