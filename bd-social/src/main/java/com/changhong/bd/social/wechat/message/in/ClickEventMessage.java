package com.changhong.bd.social.wechat.message.in;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 
 */
public class ClickEventMessage extends BaseEventMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7365192266291670780L;

	private String EventKey;

	public ClickEventMessage(){
		super();
	}
	public ClickEventMessage(BaseEventMessage msg) {
		super(msg);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
