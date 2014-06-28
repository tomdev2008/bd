package com.changhong.bd.social.wechat.message.in;

/**
 * scan qr code event
 * @author Sunrui
 * 
 */
public class ScanEventInMessage extends BaseEventMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1467194176218664169L;

	
	private String EventKey;
	
	//use ticket get qr image url.
	private String Ticket;

	public ScanEventInMessage(){
		
	}
	public ScanEventInMessage(BaseEventMessage bem){
		super(bem);
	}
	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
	
}
