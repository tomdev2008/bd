package com.changhong.bd.social.wechat.message.in;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 内容基础信息 
 */
public class BaseInTextMessage extends BaseInMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7811508933105801954L;
	// 消息id，64位整型
	private long MsgId;
	
	public BaseInTextMessage(){
		super();
	}
	public BaseInTextMessage(BaseInMessage msg) {
		super(msg);
	}
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
