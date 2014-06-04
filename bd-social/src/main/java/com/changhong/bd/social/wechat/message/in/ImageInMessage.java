package com.changhong.bd.social.wechat.message.in;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 图片信息进入
 */
public class ImageInMessage extends BaseInMessage {
	private static final long serialVersionUID = 7755592625615958199L;
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}