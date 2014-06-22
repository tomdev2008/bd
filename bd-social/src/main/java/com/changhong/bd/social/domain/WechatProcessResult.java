package com.changhong.bd.social.domain;

import java.io.Serializable;

import com.changhong.bd.social.wechat.message.out.BaseOutMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 微信结果处理器
 */
public class WechatProcessResult implements Serializable{

	private static final long serialVersionUID = 142212552517151804L;

	//是否需要进行频道变更，null表示不需要
	private WechatChannelDto channel = null;
	
	
	//对外发送的MSG
	private BaseOutMessage msg = null;

	public WechatProcessResult(){
		
	}
	
	public WechatProcessResult(BaseOutMessage msg, WechatChannelDto channel){
		this.msg = msg;
		this.channel = channel;
	}
	
	public WechatChannelDto getChannel() {
		return channel;
	}


	public void setChannel(WechatChannelDto channel) {
		this.channel = channel;
	}


	public BaseOutMessage getMsg() {
		return msg;
	}


	public void setMsg(BaseOutMessage msg) {
		this.msg = msg;
	}
	
	
	
}
