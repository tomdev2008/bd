package com.changhong.bd.social.service.api;

import com.changhong.bd.social.domain.WechatQrcodeDto;
import com.changhong.bd.social.domain.WechatQrcodeImageDto;
/**
 * Qrcode service
 * @author Sunrui
 * @date 2014年6月28日
 */
public interface WechatQrcodeService {

	/**
	 * get qrcode image url
	 * @param dto
	 * @return
	 */
	public abstract WechatQrcodeImageDto createCode(WechatQrcodeDto dto);

}