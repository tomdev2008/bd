package com.changhong.bd.spider.entity.abs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 爬虫的基础超类实体
 */
@MappedSuperclass
public abstract class AbsSpiderEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5334566635227770494L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id", insertable = true, updatable = false, nullable = false)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
