package com.changhong.bd.core.dao.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 基础hibernate dao
 */
@SuppressWarnings("rawtypes")
public interface BaseHibernateDao<T extends Serializable, PK extends Serializable> {

	public HibernateTemplate getHibernateTemplate();
	
	public Session getSession();
	
	public SessionFactory getSessionFactory();
	
	
	//##########

	// 根据主键获取实体。如果没有相应的实体，返回 null。
	public abstract T query(PK id);

	// 根据主键获取实体并加锁。如果没有相应的实体，返回 null。
	public abstract T queryWithLock(PK id, LockMode lock);

	// 根据主键获取实体。如果没有相应的实体，抛出异常。
	public abstract T load(PK id);

	// 根据主键获取实体并加锁。如果没有相应的实体，抛出异常。
	public abstract T loadWithLock(PK id, LockMode lock);

	// 获取全部实体。
	public abstract List<T> queryAll();

	// 更新实体
	public abstract void update(T entity);

	// 更新实体并加锁
	public abstract void updateWithLock(T entity, LockMode lock);

	// 存储实体到数据库
	public abstract T save(T entity);

	// 增加或更新实体
	public abstract T saveOrUpdate(T entity);

	// 增加或更新集合中的全部实体
	public abstract void saveOrUpdateAll(Collection<T> entities);

	// 删除指定的实体
	public abstract void delete(T entity);

	// 加锁并删除指定的实体
	public abstract void deleteWithLock(T entity, LockMode lock);

	// 根据主键删除指定实体
	public abstract void deleteByKey(PK id);

	// 根据主键加锁并删除指定的实体
	public abstract void deleteByKeyWithLock(PK id, LockMode lock);

	// 删除集合中的全部实体
	public abstract void deleteAll(Collection<T> entities);

	// 使用HSQL语句直接增加、更新、删除实体
	public abstract int bulkUpdate(String queryString);

	// 使用带参数的HSQL语句增加、更新、删除实体
	public abstract int bulkUpdate(String queryString, Object[] values);

	// 使用HSQL语句检索数据
	public abstract List<T> queryHql(String queryString);

	// 使用带参数的HSQL语句检索数据
	public abstract List<T> query(String queryString, Object[] values);

	// 使用带命名的参数的HSQL语句检索数据
	public abstract List<T> queryByNamedParam(String queryString, String[] paramNames, Object[] values);

	// 使用命名的HSQL语句检索数据
	public abstract List<T> queryByNamedQuery(String queryName);

	// 使用带参数的命名HSQL语句检索数据
	public abstract List<T> queryByNamedQuery(String queryName, Object[] values);

	// 使用带命名参数的命名HSQL语句检索数据
	public abstract List<T> queryByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values);

	// 使用HSQL语句检索数据，返回 Iterator
	public abstract Iterator iterate(String queryString);

	// 使用带参数HSQL语句检索数据，返回 Iterator
	public abstract Iterator iterate(String queryString, Object[] values);

	// 关闭检索返回的 Iterator
	public abstract void closeIterator(Iterator it);

	// 创建与会话无关的检索标准
	public abstract DetachedCriteria createDetachedCriteria();

	// 创建与会话绑定的检索标准
	public abstract Criteria createCriteria();

	// 检索满足标准的数据
	public abstract List<T> queryByCriteria(DetachedCriteria criteria);

	// 检索满足标准的数据，返回指定范围的记录
	public abstract List<T> queryByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

	// 使用指定的实体及属性检索（满足除主键外属性＝实体值）数据
	public abstract List<T> queryEqualByEntity(T entity, String[] propertyNames);

	// 使用指定的实体及属性检索（满足属性 like 串实体值）数据
	public abstract List<T> queryLikeByEntity(T entity, String[] propertyNames);

	// 使用指定的检索标准获取满足标准的记录数
	public abstract Long queryRowCount(DetachedCriteria criteria);

	// 使用指定的检索标准检索数据，返回指定统计值(max,min,avg,sum)
	public abstract Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName);

	// 加锁指定的实体
	public abstract void lock(T entity, LockMode lock);

	// 强制初始化指定的实体
	public abstract void initialize(Object proxy);

	// 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	public abstract void flush();
}
