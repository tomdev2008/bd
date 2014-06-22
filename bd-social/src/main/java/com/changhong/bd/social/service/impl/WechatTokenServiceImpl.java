package com.changhong.bd.social.service.impl;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.network.service.api.NetworkService;
import com.changhong.bd.social.domain.WechatAccessToken;
import com.changhong.bd.social.service.api.WechatKeyService;
import com.changhong.bd.social.service.api.WechatTokenService;
import com.changhong.bd.social.utils.WechatUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
@Service("wechatTokenService")
public class WechatTokenServiceImpl 
	implements WechatTokenService{

	private static Logger logger = LoggerFactory.getLogger(WechatTokenServiceImpl.class);
	
	private static WechatAccessToken wxt = null;
	private static DateTime deadTime = null;
	
	@Autowired
	private NetworkService networkService;
	
	@Autowired
	private WechatKeyService wechatKeyService;
	
	@Override
	public WechatAccessToken queryToken() {
		DateTime cur = new DateTime();
		
		int c = 0;
		if(null!=deadTime){
			c = cur.compareTo(deadTime);
		}
		if(wxt!=null && c==-1){
			return wxt;
		}else{
			WechatAccessToken t = this.queryTokenImpl();
			wxt = t;
			int seconds = t.getExpiresIn();
			deadTime = cur.plusSeconds((seconds - 100));
			return wxt;
		}
	}

	@Override
	public void freshToken() {
		this.queryTokenImpl();
	}
	/**
	 * TOKEN查询实现类
	 * @param ak
	 * @param sk
	 * @return
	 */
	public WechatAccessToken queryTokenImpl() {
		
		String ak = this.wechatKeyService.queryAk();
		String sk = this.wechatKeyService.querySk();
		
		WechatAccessToken accessToken = null;

		String requestUrl = WechatUtils.getAccessTokenUrl().replace("APPID", ak).replace("APPSECRET", sk);
		JSONObject jsonObject = networkService.httpsRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new WechatAccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
}
