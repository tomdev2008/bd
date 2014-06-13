package com.changhong.bd.pay.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.pay.dao.api.PayRequestDao;
import com.changhong.bd.pay.entity.PayRequestEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description : 
 */
@Repository("payRequestDao")
public class PayRequestDaoImpl 
	extends MainHibernateDao<PayRequestEntity, String>
	implements PayRequestDao{

}
