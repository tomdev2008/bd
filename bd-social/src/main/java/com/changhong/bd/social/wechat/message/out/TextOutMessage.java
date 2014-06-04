package com.changhong.bd.social.wechat.message.out;

import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 回复文本信息
 */
public class TextOutMessage extends BaseOutMessage {
	private static final long serialVersionUID = -4933717325425571885L;
	
	public TextOutMessage(){
		this.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_TEXT);
	}
	public TextOutMessage(BaseInMessage msg){
		super(msg);
		this.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_TEXT);
	}
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
