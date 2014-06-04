package com.changhong.bd.spider.wechat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.social.entity.SocialWechatMessage;
import com.changhong.bd.social.plugin.AbsWechatProcessPlugin;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.utils.WechatXmlUtils;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.social.wechat.message.out.Article;
import com.changhong.bd.social.wechat.message.out.NewsOutMessage;
import com.changhong.bd.spider.entity.SpiderClassifiedNews;
import com.changhong.bd.spider.service.api.SpiderNewsService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 微信爬虫插件 - 处理新闻信息
 */
@Service("wechatSpiderNewsPlugin")
public class WechatSpiderNewsPlugin extends AbsWechatProcessPlugin{

	@Autowired
	private SpiderNewsService spiderNewsService;
	
	private static Logger logger = LoggerFactory.getLogger(WechatSpiderNewsPlugin.class);

	@Override
	public String messageType() {
		logger.info("只处理文本内容");
		return WechatMessageUtils.REQ_MESSAGE_TYPE_TEXT;
	}
	
	@Override
	public boolean want(String info) {
		logger.info("处理任何文本内容");
		return true;
	}


	@Override
	public Integer getPriority() {
		//处理所有的文本内容，所以优先级最低
		return 0;
	}

	@Override
	public String process(BaseInMessage msg, List<SocialWechatMessage> history, String accountId) {
		TextInMessage tim = (TextInMessage)msg;
		
		String content = tim.getContent();
		JsonPageData<SpiderClassifiedNews> jpd = spiderNewsService.query(1, 3, content, null, null);
		
		NewsOutMessage newsMessage = new NewsOutMessage(msg);
		newsMessage.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
		
		List<Article> articleList = new ArrayList<Article>();
		
		List<SpiderClassifiedNews> list = jpd.getDatas();
		if(null!=list){
			for(int i=0;i<list.size();i++){
				SpiderClassifiedNews n = list.get(i);
			
				Article art = new Article();
				art.setTitle(n.getTitle());
				art.setDescription("");
				
				String pic = n.getPictureUrl();
				if(StringUtils.isEmpty(pic)){
					pic = "http://bdspider.duapp.com/static/spider/news/defualt.jpg";
				}
				art.setPicUrl(pic);
				art.setUrl(n.getWebUrl());
				
				articleList.add(art);
			}
		}
		
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		String resp = WechatXmlUtils.newsMessageToXml(newsMessage);
		return resp;
	}

}
