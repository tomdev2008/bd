package com.changhong.bd.social.parser;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.wechat.message.in.BaseEventMessage;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;
import com.changhong.bd.social.wechat.message.in.ClickEventMessage;
import com.changhong.bd.social.wechat.message.in.TextInMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 微信信息处理器 TODO
 */
@Service("wechatMessageParser")
public class WechatMessageParser {

	/**
	 * 将Map数据转为对象数据
	 * @param map
	 * @return
	 */
	public BaseInMessage parse(Map<String,String> map){
		BaseInMessage msg = new BaseInMessage();
		// 发送方帐号（open_id）
		String fromUserName = map.get("FromUserName");
		// 公众帐号
		String toUserName = map.get("ToUserName");
		// 消息类型
		String msgType = map.get("MsgType");
		String createTime = map.get("CreateTime");
		
		//new BaseInMessage();
		msg.setFromUserName(fromUserName);
		msg.setToUserName(toUserName);
		msg.setMsgType(msgType);
		msg.setCreateTime(Long.valueOf(createTime));
		
		if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_TEXT)) {
			TextInMessage tim = parseTextMessage(msg, map);
			return tim;
		}else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_EVENT)) {
			BaseEventMessage em = new BaseEventMessage(msg);
			String event = map.get("Event");
			em.setEvent(event);
			//点击事件类型
			if(event.equals(WechatMessageUtils.EVENT_TYPE_CLICK)){
				return this.parseClickEventMessage(em, map);
			}
		}
		//TODO 其他类型
		return msg;
	}
	
	/**
	 * 还原点击事件类型
	 * @param msg
	 * @param map
	 * @return
	 */
	public ClickEventMessage parseClickEventMessage(BaseEventMessage msg, Map<String,String> map){
		ClickEventMessage ceg = new ClickEventMessage(msg);
		String eventKey = map.get("EventKey");
		ceg.setEventKey(eventKey);
		return ceg;
	}
	/**
	 * 将信息还原为文字信息数据
	 * @param msg
	 * @param map
	 * @return
	 */
	public TextInMessage parseTextMessage(BaseInMessage msg, Map<String,String> map){
		TextInMessage tim = new TextInMessage(msg);
		String msgId = map.get("MsgId");
		String content = map.get("Content");
		tim.setMsgId(Long.valueOf(msgId));
		tim.setContent(content);
		
		return tim;
	}
}
