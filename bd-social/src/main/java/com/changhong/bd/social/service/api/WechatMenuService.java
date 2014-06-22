package com.changhong.bd.social.service.api;

import com.changhong.bd.social.domain.WechatMenu;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
public interface WechatMenuService {
	/**
	 * 创建微信菜单
	 * @param menu
	 * @param accessToken
	 * @return
	 */
	public int createMenu(WechatMenu menu, String accessToken);
}
