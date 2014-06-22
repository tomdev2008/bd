package com.changhong.bd.social.wechat.message.in;

import java.io.Serializable;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 消息基类（普通用户 -> 公众帐号）, 基类，所有的服务器接收信息类，必须扩展自这个类
 */
public class BaseInMessage implements Serializable{
	private static final long serialVersionUID = 3486639249704639013L;
	// 开发者微信号
	private String ToUserName;
	// 发送方帐号（一个OpenID）
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/image/location/link/ event）
	private String MsgType;
	
	public BaseInMessage(){
		
	}
	public BaseInMessage(BaseInMessage msg){
		this.ToUserName = msg.getToUserName();
		this.FromUserName = msg.getFromUserName();
		this.CreateTime = msg.getCreateTime();
		this.MsgType = msg.getMsgType();
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}

