package com.changhong.bd.lotaste.wechat.plugins;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.wechat.message.in.ScanEventInMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.changhong.bd.social.wechat.plugin.AbsProcessScanEventPlugin;

@Component
public class MoneyScanEventPlugin 
	extends AbsProcessScanEventPlugin{

	@Override
	public boolean want(String qrscene) {
		return true;
	}

	public MoneyScanEventPlugin(){
		System.out.println("hehe");
	}
	@Override
	public Integer getPriority() {
		return 200;
	}

	@Override
	public WechatProcessResult process(ScanEventInMessage msg) {
		//默认回复  回复文本消息 demo
		TextOutMessage textMessage = new TextOutMessage(msg);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		
		//返回默认信息
		textMessage.setContent(msg.getEventKey());
		
		WechatProcessResult res = new WechatProcessResult(textMessage, null);
		
		return res;
	}

}
