package com.changhong.bd.core.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.utils.ResourceUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月4日
 * @version 1.0
 * @description : 本地系统属性服务
 * TODO
 */
@Service
public class LocalSysPropertiesServiceImpl {
	
	private static Logger logger = LoggerFactory.getLogger(LocalSysPropertiesServiceImpl.class);
	
	private static final String FILE_PATTERN = "classpath*:/app.properties";
	
	@PostConstruct
	public void init() throws IOException{
		Resource[] reses = ResourceUtils.getPatternResource(FILE_PATTERN);
		if(null!=reses && reses.length>0){
			for(Resource res : reses){
				logger.info("load {} file : {}", FILE_PATTERN, res.getURL().toString());
				File file = res.getFile();
				InputStream is = new FileInputStream(file);
				Properties p = new Properties();
				p.load(is);
				
				Set<Object> sets = p.keySet();
				for(Object o : sets){
					Object v = p.get(o);
					logger.info("set property {} : {}", o, v);
					System.setProperty((String)o, (String)v);
				}
			}
		}
	}
	
	
}
