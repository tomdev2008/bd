package com.changhong.bd.social.domain;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
public class WechatSubUrlButton extends WechatBaseButton{
	private static final long serialVersionUID = 5153443389240764085L;
	
	private String type = "view";
	
	//菜单URL
	private String url;
	
	public WechatSubUrlButton(String name, String url){
		super(name);
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
