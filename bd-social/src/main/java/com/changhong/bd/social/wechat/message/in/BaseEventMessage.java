package com.changhong.bd.social.wechat.message.in;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 
 */
public class BaseEventMessage extends BaseInMessage{

	private static final long serialVersionUID = -8082382854389376073L;
	//事件类型
	private String Event;
	
	public BaseEventMessage(BaseEventMessage msg) {
		super(msg);
		this.Event = msg.getEvent();
	}
	public BaseEventMessage(BaseInMessage msg){
		super(msg);
	}
	public BaseEventMessage(){
		
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
