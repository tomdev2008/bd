package com.changhong.bd.quartz.service.api;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.quartz.domain.QuartzTaskLogDto;
import com.changhong.bd.quartz.entity.QuartzTaskLog;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 
 *
 */
public interface QuartzTaskLogService {

	/**
	 * 查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public JsonPageData<QuartzTaskLog> query(Integer pageNo, Integer pageSize);
	
	/**
	 * 新增
	 * @param e
	 * @return
	 */
	public QuartzTaskLogDto add(QuartzTaskLog e);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id);
	
}
