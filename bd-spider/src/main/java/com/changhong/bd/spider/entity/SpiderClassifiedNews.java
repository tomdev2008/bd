package com.changhong.bd.spider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.changhong.bd.spider.entity.abs.AbsSpiderEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 分类新闻
 */
@Entity
@Table(name="spider_classified_news")
public class SpiderClassifiedNews extends AbsSpiderEntity{

	private static final long serialVersionUID = -5292295793128840862L;

	@Column(name="title")
	private String title;
	
	@Column(name="weburl")
	private String webUrl;
	
	@Column(name="pictureurl")
	private String pictureUrl;
	
	@Column(name="category")
	private String category;
	
	@Column(name="classifydate")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime classifyDate;
	
	@Column(name="isrecommend")
	
	private Integer isRecommend;
	
	@Column(name="recommendtime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime recommendTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public DateTime getClassifyDate() {
		return classifyDate;
	}

	public void setClassifyDate(DateTime classifyDate) {
		this.classifyDate = classifyDate;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public DateTime getRecommendTime() {
		return recommendTime;
	}

	public void setRecommendTime(DateTime recommendTime) {
		this.recommendTime = recommendTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
