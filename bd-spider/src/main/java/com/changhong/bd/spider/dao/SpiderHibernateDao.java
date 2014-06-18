package com.changhong.bd.spider.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.changhong.bd.core.dao.impl.abs.BaseHibernateDaoImpl;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : 爬虫基础Dao
 */
public class SpiderHibernateDao <T extends Serializable, PK extends Serializable>
	extends BaseHibernateDaoImpl<T,PK>{
	
	@Autowired
	@Qualifier("spiderHibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Qualifier("spiderSessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
