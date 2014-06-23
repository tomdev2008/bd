package com.changhong.bd.lotaste.wechat;

import java.util.List;

import org.springframework.stereotype.Component;

import com.changhong.bd.lotaste.utils.NameUtils;
import com.changhong.bd.social.entity.SocialWechatMessage;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.changhong.bd.social.wechat.parser.OutMessageXmlParser;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 
 */
@Component
public class WechatProcessMessage {
//	extends AbsWechatProcessPlugin{
//
//	@Override
//	public boolean want(String info) {
//		return true;
//	}
//
//	@Override
//	public String messageType() {
//		return "*";
//	}
//
//	@Override
//	public Integer getPriority() {
//		return 1;
//	}
//
//	@Override
//	public String process(BaseInMessage msg, List<SocialWechatMessage> history, String accountId) {
//		TextOutMessage textMessage = new TextOutMessage(msg);
//			//提示，欢迎某某，这里是帮助信息
//			String content = NameUtils.CN_NAME + "欢迎您!";
//			textMessage.setContent(content);
//
//		return WechatXmlUtils.textMessageToXml(textMessage);
//	}

}
