package com.changhong.bd.spider.wechat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.ClickEventMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.changhong.bd.social.wechat.plugin.AbsProcessButtonEventPlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月26日
 * @version 1.0
 * @description : 微信客服插件
 */
@Service
public class WechatServiceClickPlugin extends AbsProcessButtonEventPlugin{

	@Override
	public String getEventKey() {
		return "wechat_service";
	}

	@Override
	public Integer getPriority() {
		return 30;
	}

	@Override
	public WechatProcessResult process(ClickEventMessage msg, WechatChannelDto channel) {
		if(StringUtils.isNotEmpty(channel.getWechatChannelId())){
			//需要切换频道
			WechatChannelDto dto = new WechatChannelDto(msg.getFromUserName(), "wechat_service", "微信客服", "");
			TextOutMessage textMessage = new TextOutMessage(msg);
			textMessage.setContent("微信客服：请发送信息，稍后会有客服与您联系");

			WechatProcessResult res = new WechatProcessResult(textMessage, dto);
			
			return res;
		}else{
			//无需切换频道
			WechatProcessResult res = new WechatProcessResult(null, null);
			return res;
		}
	}

}
