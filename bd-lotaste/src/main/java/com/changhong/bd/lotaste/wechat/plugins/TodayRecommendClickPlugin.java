package com.changhong.bd.lotaste.wechat.plugins;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.wechat.message.in.ClickEventMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.changhong.bd.social.wechat.plugin.AbsProcessButtonEventPlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月23日
 * @version 1.0
 * @description : 
 */
@Component
public class TodayRecommendClickPlugin extends AbsProcessButtonEventPlugin {

	@Override
	public String getEventKey() {
		return "today_recommend";
	}

	@Override
	public Integer getPriority() {
		return 100;
	}

	@Override
	public WechatProcessResult process(ClickEventMessage msg, WechatChannelDto channel) {
		TextOutMessage textMessage = new TextOutMessage(msg);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		
		//返回默认信息
		textMessage.setContent("今日推荐按钮");
		
		WechatProcessResult res = new WechatProcessResult(textMessage, null);
		return res;
	}

	

}
