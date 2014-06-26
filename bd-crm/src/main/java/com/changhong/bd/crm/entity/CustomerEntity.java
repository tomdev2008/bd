package com.changhong.bd.crm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 
 */
@Entity
@Table(name="crm_customer")
public class CustomerEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 2498766554416409175L;

	
}
