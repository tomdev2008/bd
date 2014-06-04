package com.changhong.bd.social.wechat.message.out;

import java.util.List;

import com.changhong.bd.social.wechat.message.in.BaseInMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : 
 */
public class NewsOutMessage extends BaseOutMessage {
	private static final long serialVersionUID = 7105373714768002924L;
	// 图文消息个数，限制为10条以内
	private int ArticleCount;
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> Articles;

	public NewsOutMessage(){
		
	}
	public NewsOutMessage(BaseInMessage msg) {
		super(msg);
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}