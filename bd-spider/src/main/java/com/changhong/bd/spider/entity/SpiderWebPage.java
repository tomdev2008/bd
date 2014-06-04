package com.changhong.bd.spider.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月15日
 * @version 1.0
 * @description : //TODO
 */
@Entity
@Table(name="webapp") 
public class SpiderWebPage extends AbsEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1385940897369926139L;
//	id	varchar	255	0	0	0	0	0	0		0		utf8	utf8_general_ci		-1	0
//	headers	blob	0	0	-1	0	0	0	0		0					0	0
//	text	longtext	0	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
//	status	int	11	0	-1	0	0	0	0		0					0	0
//	markers	blob	0	0	-1	0	0	0	0		0					0	0
//	parseStatus	blob	0	0	-1	0	0	0	0		0					0	0
//	modifiedTime	bigint	20	0	-1	0	0	0	0		0					0	0
//	prevModifiedTime	bigint	20	0	-1	0	0	0	0		0					0	0
//	score	float	0	0	-1	0	0	0	0		0					0	0
//	typ	varchar	32	0	-1	0	0	0	0		0		latin1	latin1_swedish_ci		0	0
//	batchId	varchar	32	0	-1	0	0	0	0		0		latin1	latin1_swedish_ci		0	0
//	baseUrl	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
//	content	longblob	0	0	-1	0	0	0	0		0					0	0
//	title	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
//	reprUrl	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
//	fetchInterval	int	11	0	-1	0	0	0	0		0					0	0
//	prevFetchTime	bigint	20	0	-1	0	0	0	0		0					0	0
//	inlinks	mediumblob	0	0	-1	0	0	0	0		0					0	0
//	prevSignature	blob	0	0	-1	0	0	0	0		0					0	0
//	outlinks	mediumblob	0	0	-1	0	0	0	0		0					0	0
//	fetchTime	bigint	20	0	-1	0	0	0	0		0					0	0
//	retriesSinceFetch	int	11	0	-1	0	0	0	0		0					0	0
//	protocolStatus	blob	0	0	-1	0	0	0	0		0					0	0
//	signature	blob	0	0	-1	0	0	0	0		0					0	0
//	metadata	blob	0	0	-1	0	0	0	0		0					0	0


}
