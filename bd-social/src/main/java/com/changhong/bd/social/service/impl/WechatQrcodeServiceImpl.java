package com.changhong.bd.social.service.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.network.service.api.NetworkService;
import com.changhong.bd.social.domain.WechatAccessToken;
import com.changhong.bd.social.domain.WechatQrcodeDto;
import com.changhong.bd.social.domain.WechatQrcodeImageDto;
import com.changhong.bd.social.service.api.WechatQrcodeService;
import com.changhong.bd.social.service.api.WechatTokenService;

/**
 * wechat qrcode service
 * @author Sunrui
 * @date 2014年6月28日
 */
@Service
public class WechatQrcodeServiceImpl implements WechatQrcodeService {

	//get qrcode url
	public static final String CODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=${token}";
	public static final String IMAGE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=${ticket}";
	
	private Logger logger = LoggerFactory.getLogger(WechatQrcodeServiceImpl.class);
	@Autowired
	private WechatTokenService wechatTokenService;
	@Autowired
	private NetworkService networkSerivce;
	
	/* (non-Javadoc)
	 * @see com.changhong.bd.social.service.impl.WechatQrcodeService#createCode(com.changhong.bd.social.domain.WechatQrcodeDto)
	 */
	@Override
	public WechatQrcodeImageDto createCode(WechatQrcodeDto dto){
		Integer expireTime = dto.getExpireTime();
		if(0 == expireTime){
			return this.createEverCode(dto);
		}else{
			return this.createTmpCode(dto);
		}
	}
	public WechatQrcodeImageDto createTmpCode(WechatQrcodeDto dto){
		String data = "{\"expire_seconds\": " + dto.getExpireTime() + ", \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+dto.getId()+"}}}";
		return this.createCodeImple(data);
	}
	
	public WechatQrcodeImageDto createEverCode(WechatQrcodeDto dto){
		String data = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+ dto.getId() +"}}}";
		return this.createCodeImple(data);
	}
	
	public WechatQrcodeImageDto createCodeImple(String data){
		WechatAccessToken token = this.wechatTokenService.queryToken();
		String url = CODE_URL.replace("${token}", token.getToken());
		
		String is = this.networkSerivce.httpsPost(url, null, data);
		try {
			JSONObject json = JSONObject.fromObject(is);
			Object err = json.get("errcode");
			if(null!=err){
				RuntimeException re = new RuntimeException((String)err);
				throw re;
			}else{
				String ticket = (String)json.get("ticket");
				logger.info(ticket);
				Integer expire = (Integer)json.get("expire_seconds");
				
				URLCodec coder = new URLCodec();
				ticket = coder.encode(ticket, "UTF-8");
				String turl = IMAGE_URL.replace("${ticket}", ticket);
				
				WechatQrcodeImageDto dto = new WechatQrcodeImageDto(turl, expire );
				return dto;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
