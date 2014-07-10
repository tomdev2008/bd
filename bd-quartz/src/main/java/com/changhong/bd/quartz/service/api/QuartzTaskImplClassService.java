package com.changhong.bd.quartz.service.api;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.quartz.domain.QuartzTaskImplClassDto;
import com.changhong.bd.quartz.entity.QuartzTaskImplClass;

/**
 * @author QiYao
 * @date 2014年7月10日
 * @email yao.qi@changhong.com
 * @description 定时任务实现类服务
 *
 */
public interface QuartzTaskImplClassService {

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public JsonPageData<QuartzTaskImplClassDto> query(
			Integer pageNo,
			Integer pageSize
			);
	/**
	 * 新增
	 * @param e
	 */
	public QuartzTaskImplClassDto add(QuartzTaskImplClass e);
	
	/**
	 * 更新
	 * @param e
	 */
	public QuartzTaskImplClassDto update(QuartzTaskImplClass e);
	/**
	 * 通过ID查询entity实体
	 * @param id
	 * @return
	 */
	public QuartzTaskImplClass query(String id);
	/**
	 * 删除某个实体
	 * @param id
	 */
	public void delete(String id);
}
