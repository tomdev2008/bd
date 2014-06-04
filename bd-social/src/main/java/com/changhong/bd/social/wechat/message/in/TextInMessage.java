package com.changhong.bd.social.wechat.message.in;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 文本信息
 */
public class TextInMessage extends BaseInTextMessage {
	
	private static final long serialVersionUID = 3908716109571568764L;
	// 消息内容
	private String Content;

	public TextInMessage(){
		super();
	}
	public TextInMessage(BaseInMessage msg) {
		super(msg);
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
