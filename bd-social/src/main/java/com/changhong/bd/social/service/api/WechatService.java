package com.changhong.bd.social.service.api;

import java.io.InputStream;

import com.changhong.bd.social.domain.WechatMenu;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 处理微信的信息
 */
public interface WechatService {

	/**
	 * 进行消息回复
	 * @param is
	 * @return
	 */
	public String process(InputStream is);
	
}
