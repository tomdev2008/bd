package com.changhong.bd.core.domain;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 组织结构级别
 */
public class OrganizationLevelDto {

	public static final Integer department = 1; //普通部门
	public static final Integer subcompany = 5; //分公司
	public static final Integer dept_company = 6; //总公司管理部门
	public static final Integer company = 10; //公司
	
	public static final Integer sub_group = 20; //子集团
	public static final Integer dept_group = 21;//总集团管理部门
	public static final Integer group = 30;//总集团
	
}
