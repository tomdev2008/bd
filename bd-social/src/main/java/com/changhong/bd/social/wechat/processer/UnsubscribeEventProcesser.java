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
import com.changhong.bd.social.wechat.message.in.BaseEventMessage;
import com.changhong.bd.social.wechat.plugin.ProcessUnsubscribeEventPlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 取消关注事件处理器
 */
@Service
public class UnsubscribeEventProcesser {

	private static Logger logger = LoggerFactory.getLogger(UnsubscribeEventProcesser.class);
	/**
	 * 插件：取消关注，事件处理
	 */
	private List<ProcessUnsubscribeEventPlugin> unsubscribePlugins = new ArrayList<ProcessUnsubscribeEventPlugin>();
	
	@Autowired(required=false)
	public void setPlugin(List<ProcessUnsubscribeEventPlugin> list){
		if(null!=list){
			logger.info("wechat button event plugin register size：{}", list.size());
			for(ProcessUnsubscribeEventPlugin p : list){
				logger.info("wechat plugin detail: {}", p.getClass().getName());
			}
			unsubscribePlugins.addAll(list);
			Collections.sort(unsubscribePlugins);
		}
	}

	public WechatProcessResult process(BaseEventMessage em, WechatChannelDto channel) {
		// TODO Auto-generated method stub
		return null;
	}

}
