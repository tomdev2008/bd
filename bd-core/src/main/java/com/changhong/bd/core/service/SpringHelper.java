package com.changhong.bd.core.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * @author QiYao
 * @date 2014年7月7日
 * @email yao.qi@changhong.com
 * @description 获取spring上下文的帮助类
 *
 */
@Service("springHelper")
public class SpringHelper implements BeanFactoryAware {
    public static BeanFactory beanFactory = null;
 
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
	 */
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		beanFactory = arg0;
	}
}
