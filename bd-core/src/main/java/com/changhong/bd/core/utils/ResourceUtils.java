package com.changhong.bd.core.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月4日
 * @version 1.0
 * @description : 
 */
public class ResourceUtils {
	private static Logger logger = LoggerFactory.getLogger(ResourceUtils.class);
	
	/**
	 * 根据pattern获取资源
	 * @param pattern
	 * @return
	 */
	public static Resource[] getPatternResource(String pattern) {
		ResourcePatternResolver resoler = new PathMatchingResourcePatternResolver() ;
		Resource[] res = null;
		try {
			res = resoler.getResources(pattern);
		}catch(FileNotFoundException e1){
			logger.info("{},no file found.", pattern);
		}catch (IOException e) {
			logger.info("load {} error: {}", pattern, e.getMessage());
		}

		return res;
	}
}
