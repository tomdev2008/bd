package com.changhong.bd.core.dao.impl.abs;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 基础抽象类
 */
public abstract class MainHibernateDao<T extends Serializable, PK extends Serializable>
	extends BaseHibernateDaoImpl<T,PK>{


	//为了避免多数据库模型，必须指定使用的名称，抽象类注入，必须使用spring注解
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Qualifier("sessionFactory")
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
