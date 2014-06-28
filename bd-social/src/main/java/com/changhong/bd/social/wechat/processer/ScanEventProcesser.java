package com.changhong.bd.social.wechat.processer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.ScanEventInMessage;
import com.changhong.bd.social.wechat.plugin.ProcessScanEventPlugin;

/**
 * 
 * @author Sunrui
 * @date 2014年6月28日
 */
@Service
public class ScanEventProcesser {
	private static Logger logger = LoggerFactory.getLogger(ScanEventProcesser.class);
	
	private List<ProcessScanEventPlugin> plugins = new ArrayList<ProcessScanEventPlugin>();
	
	/**
	 * 注入按钮插件
	 * @param plugins
	 */
	@Autowired(required=false)
	public void setPlugin(List<ProcessScanEventPlugin> plugins){
		if(null!=plugins){
			logger.info("wechat scan event plugin register size：{}", plugins.size());
			for(ProcessScanEventPlugin p : plugins){
				logger.info("wechat plugin detail: {}", p.getClass().getName());
			}
			this.plugins.addAll(plugins);
			Collections.sort(plugins);
		}
	}
	
	public WechatProcessResult process(ScanEventInMessage cem) {
		String key = cem.getEventKey();
		for(ProcessScanEventPlugin p : plugins){
			if(p.want(key)){
				return p.process(cem);
			}
		}
		return null;
	}
}
