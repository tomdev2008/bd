package com.changhong.bd.social.wechat.processer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.social.wechat.plugin.ProcessMessagePlugin;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 信息处理器
 */
@Service
public class MessageProcesser {

	private static Logger logger = LoggerFactory.getLogger(MessageProcesser.class);
	
	/**
	 * 插件：文本信息
	 */
	private List<ProcessMessagePlugin> msgPlugins = new ArrayList<ProcessMessagePlugin>();
	
	/**
	 * 注入信息处理插件
	 * @param plugins
	 */
	@Autowired(required=false)
	public void setPlugin(List<ProcessMessagePlugin> plugins){
		if(null!=plugins){
			logger.info("wechat message plugin register size：{}", plugins.size());
			for(ProcessMessagePlugin p : plugins){
				logger.info("wechat plugin detail: {}", p.getClass().getName());
			}
			msgPlugins.addAll(plugins);
			Collections.sort(msgPlugins);
		}
	}

	public WechatProcessResult process(TextInMessage tim, WechatChannelDto channel) {
		if(null!=msgPlugins){
			for(ProcessMessagePlugin p : msgPlugins){
				String channelId = channel.getWechatChannelId();
				if(channelId.equals(p.getChannelId())){
					return p.process(tim, channel);
				}
			}
		}
		return null;
	}
}
