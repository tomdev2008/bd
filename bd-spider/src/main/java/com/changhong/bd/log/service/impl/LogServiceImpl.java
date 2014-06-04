package com.changhong.bd.log.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.changhong.bd.log.service.api.LogService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 
 */
@Service("logService")
public class LogServiceImpl implements LogService{

	@Override
	public void addLog(Serializable serial, String modifyId) {
		// TODO Auto-generated method stub
		//将对象进行序列化，然后保存
	}
	
}
