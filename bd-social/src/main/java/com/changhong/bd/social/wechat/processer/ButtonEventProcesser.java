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
import com.changhong.bd.social.wechat.message.in.ClickEventMessage;
import com.changhong.bd.social.wechat.plugin.ProcessButtonEventPlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 微信按钮时间处理器,无接口，不对外提供
 */
@Service
public class ButtonEventProcesser {
	
	private static Logger logger = LoggerFactory.getLogger(ButtonEventProcesser.class);
	
	/**
	 * 插件：处理按钮时间
	 */
	private List<ProcessButtonEventPlugin> btnEventPlugins = new ArrayList<ProcessButtonEventPlugin>();

	/**
	 * 注入按钮插件
	 * @param plugins
	 */
	@Autowired(required=false)
	public void setPlugin(List<ProcessButtonEventPlugin> plugins){
		if(null!=plugins){
			logger.info("wechat button event plugin register size：{}", plugins.size());
			for(ProcessButtonEventPlugin p : plugins){
				logger.info("wechat plugin detail: {}", p.getClass().getName());
			}
			btnEventPlugins.addAll(plugins);
			Collections.sort(btnEventPlugins);
		}
	}

	public WechatProcessResult process(ClickEventMessage cem, WechatChannelDto channel) {
		String key = cem.getEventKey();
		for(ProcessButtonEventPlugin p : btnEventPlugins){
			if(key.equals(p.getEventKey())){
				return p.process(cem, channel);
			}
		}
		return null;
	}
}
