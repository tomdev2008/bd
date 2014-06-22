package com.changhong.bd.social.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.changhong.bd.network.service.api.NetworkService;
import com.changhong.bd.social.domain.WechatMenu;
import com.changhong.bd.social.service.api.WechatMenuService;
import com.changhong.bd.social.utils.WechatUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
@Service
public class WechatMenuServiceImpl
	implements WechatMenuService{

	private Logger logger = LoggerFactory.getLogger(WechatMenuService.class);
	
	@Autowired
	private NetworkService networkService;
	
	@Override
	public int createMenu(WechatMenu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = WechatUtils.getMenuCreateUrl().replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = networkService.httpsRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				logger.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}

		return result;
	}

}
