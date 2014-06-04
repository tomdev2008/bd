package com.changhong.bd.core.utils;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 分页工具类
 */
public class PageUtils {

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return Integer[0] firstResult  Integer[1] maxResult
	 */
	public static Integer[] page(Integer pageNo, Integer pageSize){
		if(null!=pageNo && null!=pageSize){
			Integer start = (pageNo - 1)*pageSize;
			return new Integer[]{start, pageSize};
		}else{
			return null;
		}
	}
}
